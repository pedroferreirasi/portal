package br.com.informa.repositories.dao.portalrh;


import br.com.informa.repositories.dao.hibernate.HibernateDao;
import br.com.informa.repositories.dao.hibernate.HibernateSessionFactory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.informa.models.portalrh.Aviso;
import br.com.informa.models.portalrh.AvisoDestinatario; 
 
public class AvisoDestinatarioDaoImpl extends HibernateDao<AvisoDestinatario, Integer>  implements AvisoDestinatarioDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<AvisoDestinatario> getAvisosPorUsuario(Integer pk) {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Aviso.class);
		criteria.add(Restrictions.eq("AvisoDestinatario.usuario.id", pk));
		return criteria.list();
	} 
 
} 
