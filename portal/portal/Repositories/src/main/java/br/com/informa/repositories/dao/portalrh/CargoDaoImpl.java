package br.com.informa.repositories.dao.portalrh;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.informa.models.portalrh.Cargo;
import br.com.informa.repositories.dao.hibernate.HibernateDao;
import br.com.informa.repositories.dao.hibernate.HibernateSessionFactory; 
 
@Repository
public class CargoDaoImpl extends HibernateDao<Cargo, Integer>  implements CargoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Cargo> getCargoPorNome(String nome) {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Cargo.class);
		criteria.add(Restrictions.like("descricao", nome+"%"));
		return criteria.list();
	} 
 

} 
