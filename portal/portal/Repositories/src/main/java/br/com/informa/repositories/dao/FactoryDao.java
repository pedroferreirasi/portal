package br.com.informa.repositories.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.informa.repositories.dao.common.GrupoUsuarioDao;
import br.com.informa.repositories.dao.common.IGrupoUsuarioDao;
import br.com.informa.repositories.dao.common.IUsuarioDao;
import br.com.informa.repositories.dao.common.UsuarioDao;
import br.com.informa.repositories.dao.hibernate.HibernateDaoFactory;
import br.com.informa.repositories.dao.portalrh.CargoDao;
import br.com.informa.repositories.dao.portalrh.ColaboradorDao;
import br.com.informa.repositories.dao.portalrh.DepartamentoDao;
import br.com.informa.repositories.dao.portalrh.DependentesDao;
import br.com.informa.repositories.dao.portalrh.DocumentoInternoDao;
import br.com.informa.repositories.dao.portalrh.EquipesDao;
import br.com.informa.repositories.dao.portalrh.FeriasDao;
import br.com.informa.repositories.dao.portalrh.ICargoDao;
import br.com.informa.repositories.dao.portalrh.IColaboradorDao;
import br.com.informa.repositories.dao.portalrh.IDepartamentoDao;
import br.com.informa.repositories.dao.portalrh.IDependentesDao;
import br.com.informa.repositories.dao.portalrh.IDocumentoInternoDao;
import br.com.informa.repositories.dao.portalrh.IEquipesDao;
import br.com.informa.repositories.dao.portalrh.IFeriasDao;
import br.com.informa.repositories.dao.portalrh.ITipoDocumentoInternoDao;
import br.com.informa.repositories.dao.portalrh.TipoDocumentoInternoDao;

public abstract class FactoryDao {

	@SuppressWarnings("rawtypes")
	private static final Class FACTORY_CLASS = HibernateDaoFactory.class;

	public static FactoryDao getFactory() {
		try {
			return (FactoryDao) FACTORY_CLASS.newInstance();
		} catch (InstantiationException e) {
			Logger.getGlobal().log(Level.SEVERE,"",e);
			throw new RuntimeException();
		} catch (IllegalAccessException e) {
			Logger.getGlobal().log(Level.SEVERE,"",e);
			throw new RuntimeException();
		}		
	}
	
	public IGrupoUsuarioDao getGrupoUsuarioDao() {
		return new GrupoUsuarioDao();
	}
	
	public IUsuarioDao getUsuarioDao() {
		return new UsuarioDao();
	}	
	
	public ICargoDao getCargoDao() {
		return new CargoDao();
	}
	
	public IDepartamentoDao getDepartamentoDao() {
		return new DepartamentoDao();
	}		

	public ITipoDocumentoInternoDao getTipoDocumentoInternoDao() {
		return new TipoDocumentoInternoDao();
	}
	
	public IDocumentoInternoDao getDocumentoInternoDao() {
		return new DocumentoInternoDao();
	}
	
	public IColaboradorDao getColaboradorDao() {
		return new ColaboradorDao();
	}
	
	public IDependentesDao getDependentesDao() {
		return new DependentesDao();
	}	
	
	public IFeriasDao getFeriasDao() {
		return new FeriasDao();
	}	
	
	public IEquipesDao getEquipesDao() {
		return new EquipesDao();
	}		
}
