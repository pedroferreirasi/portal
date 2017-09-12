package br.com.informa.repositories.dao.portalrh;


import br.com.informa.repositories.dao.hibernate.HibernateDao;
import br.com.informa.repositories.dao.hibernate.HibernateSessionFactory;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import br.com.informa.models.portalrh.Mural; 
 
public class MuralDaoImpl extends HibernateDao<Mural, Integer>  implements MuralDao { 

	@SuppressWarnings("unchecked")
	@Override
	public List<Mural> getListAll() {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Mural.class);
		criteria.addOrder(Order.desc("dataCadastro"));
		return criteria.list();
	}
} 
