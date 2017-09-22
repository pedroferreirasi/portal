package br.com.informa.repositories.dao.portalrh;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getAniversariantesDoMes(String mes) {
		String hql = "from Usuario usuario  "+
	                 " where month(usuario.dadosPessoais.dataNascimento) = :pmes ";
		Query qry = HibernateSessionFactory.getSession().createQuery(hql);
		qry.setParameter("pmes", 12);
		return (List<Usuario>) qry.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getColaboradoresPorChefia(Integer idChefia) {
		String hql = "from Usuario usuario  "+
                " where usuario.dadosProfissionais.chefia.id = :parametro ";
	    Query qry = HibernateSessionFactory.getSession().createQuery(hql);	
	    qry.setParameter("parametro", idChefia);
	    
		return qry.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getColaboradoresPorCargo(Integer idCargo) {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("cargo.id", idCargo));
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> getColaboradoresPorNome(String nome) {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(Usuario.class);
		criteria.add(Restrictions.like("nomeCompleto", nome+"%"));
		return criteria.list();
	}	
}
