package br.com.informa.repositories.dao.portalrh;

import br.com.informa.repositories.dao.hibernate.HibernateDao;
import br.com.informa.repositories.dao.hibernate.HibernateSessionFactory;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.informa.models.portalrh.Ferias; 
 
public class FeriasDaoImpl extends HibernateDao<Ferias, Integer>  implements FeriasDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Ferias> getListAllByUsuario(Integer idUsuario) {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Ferias.class);
		criteria.add(Restrictions.eq("usuario.id", idUsuario));
		return criteria.list();
	} 
 

} 
