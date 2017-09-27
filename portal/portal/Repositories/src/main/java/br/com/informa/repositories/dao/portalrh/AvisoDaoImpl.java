package br.com.informa.repositories.dao.portalrh;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.informa.models.portalrh.Aviso;
import br.com.informa.models.portalrh.AvisoDestinatario;
import br.com.informa.repositories.dao.hibernate.HibernateDao;
import br.com.informa.repositories.dao.hibernate.HibernateSessionFactory; 
 
public class AvisoDaoImpl extends HibernateDao<Aviso, Integer>  implements AvisoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Aviso> getAvisosNaoLido(Integer idUsuario) {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Aviso.class);
		criteria.add(Restrictions.eqProperty("AvisoDestinatario.aviso", "id"));
		
		criteria.add(Restrictions.eq("AvisoDestinatario.lido", false));
		criteria.add(Restrictions.eq("AvisoDestinatario.usuario.id", idUsuario));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Aviso> getAllAvisos(Integer idUsuario) {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Aviso.class);
		criteria.add(Restrictions.eq("listaDestinatario.usuario.id", idUsuario));
		return criteria.list();
	}

 
} 
