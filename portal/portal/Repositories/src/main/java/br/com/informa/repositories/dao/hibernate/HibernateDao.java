package br.com.informa.repositories.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import br.com.informa.repositories.dao.IDao;

public abstract class HibernateDao<T, PK extends Serializable> implements IDao<T, PK> {

	//protected static final Logger logger = LoggerFactory.getLogger(HibernateDao.class);
	Session session;
	Transaction tx;

	public void closeSession() {
		try {
			HibernateSessionFactory.getSession().close();
		} catch (HibernateException e) {
			//logger.error("Couldn�t close session", e);
		}
	}

	@Override
	public void Add(T entity) {
		HibernateSessionFactory.getSession().persist(entity);
		//logger.info("Entity added successfully, Entity Details =" + entity);
	}

	@Override
	public void Update(T entity) {
		HibernateSessionFactory.getSession().update(entity);
		// logger.info("Entity updated successfully, Entity Details =" + entity);
	}

	@Override
	public void delete(T entity) {
		HibernateSessionFactory.getSession().delete(entity);
		// logger.info("Entity deleted successfully, Entity details=" + entity);
	}

	@Override
	public void deleteById(PK id) {
		T entity = getById(id);
		if (entity != null) {
			delete(entity);
			//logger.info("Entity deleted successfully, Entity details=" + entity);
		} else {
			//logger.info("Entity not found to be deleted, Entity details=" + entity);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getListAll() {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(getTypeClass());
		//logger.info("getListAll called successfully");
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T getById(PK pk) {
		T entity = (T) HibernateSessionFactory.getSession().get(getTypeClass(), pk);
		//logger.info("getById loaded successfully, Entity details=" + entity + " / PK=" + pk);
		return entity;	
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getTypeClass() {
		Class<T> clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		return clazz;
	}
}
