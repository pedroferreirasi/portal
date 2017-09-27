package br.com.informa.repositories.dao.portalrh;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.informa.models.portalrh.AvisoDestinatario;
import br.com.informa.repositories.dao.hibernate.HibernateDao;
import br.com.informa.repositories.dao.hibernate.HibernateSessionFactory; 
 
public class AvisoDestinatarioDaoImpl extends HibernateDao<AvisoDestinatario, Integer>  implements AvisoDestinatarioDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<AvisoDestinatario> getAvisosPorUsuario(Integer idUsuario) {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(AvisoDestinatario.class);
		criteria.add(Restrictions.eq("usuario.id", idUsuario));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AvisoDestinatario> getAvisosNaoLido(Integer idUsuario) {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(AvisoDestinatario.class);
		criteria.add(Restrictions.eq("usuario.id", idUsuario));
		criteria.add(Restrictions.eq("lido", false));
		return criteria.list();
	} 
 
} 
