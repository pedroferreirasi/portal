package br.com.informa.repositories.dao.common;

import br.com.informa.repositories.dao.hibernate.HibernateDao;
import br.com.informa.repositories.dao.hibernate.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.informa.models.common.Usuario;

public class UsuarioDao extends HibernateDao<Usuario, Integer>  implements IUsuarioDao {

	@Override
	public Usuario getUserLogin(String loginName) {		
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login",loginName));
		
		Usuario user = (Usuario) criteria.uniqueResult();
		
		return user;		
	}
}
