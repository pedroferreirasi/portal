package br.com.informa.repositories.dao.portalrh;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.ETipoUsuario;
import br.com.informa.repositories.dao.hibernate.HibernateDao;
import br.com.informa.repositories.dao.hibernate.HibernateSessionFactory;

public class ColaboradorDaoImpl extends HibernateDao<Usuario, Integer>  implements ColaboradorDao {

	@Override
	public Usuario getUserLogin(String loginName) {		
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("login",loginName));
		
		Usuario user = (Usuario) criteria.uniqueResult();
		
		return user;		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getListAll() {		
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("tipoUsuario", ETipoUsuario.C));
				
		return criteria.list();	
	}	
}