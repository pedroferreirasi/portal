package br.com.informa.repositories.dao;

import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.informa.repositories.dao.common.GrupoUsuarioDaoImpl;
import br.com.informa.repositories.dao.common.GrupoUsuarioDao;
import br.com.informa.repositories.dao.common.UsuarioDao;
import br.com.informa.repositories.dao.common.UsuarioDaoImpl;
import br.com.informa.repositories.dao.hibernate.HibernateDaoFactory;
import br.com.informa.repositories.dao.portalrh.CargoDaoImpl;
import br.com.informa.repositories.dao.portalrh.ColaboradorDaoImpl;
import br.com.informa.repositories.dao.portalrh.DepartamentoDaoImpl;
import br.com.informa.repositories.dao.portalrh.DependentesDaoImpl;
import br.com.informa.repositories.dao.portalrh.DocumentoInternoDaoImpl;
import br.com.informa.repositories.dao.portalrh.EquipesDaoImpl;
import br.com.informa.repositories.dao.portalrh.FeriadosDao;
import br.com.informa.repositories.dao.portalrh.FeriadosDaoImpl;
import br.com.informa.repositories.dao.portalrh.FeriasDaoImpl;
import br.com.informa.repositories.dao.portalrh.MuralDao;
import br.com.informa.repositories.dao.portalrh.MuralDaoImpl;
import br.com.informa.repositories.dao.portalrh.SalaDao;
import br.com.informa.repositories.dao.portalrh.SalaDaoImpl;
import br.com.informa.repositories.dao.portalrh.CargoDao;
import br.com.informa.repositories.dao.portalrh.ColaboradorDao;
import br.com.informa.repositories.dao.portalrh.DepartamentoDao;
import br.com.informa.repositories.dao.portalrh.DependentesDao;
import br.com.informa.repositories.dao.portalrh.DocumentoInternoDao;
import br.com.informa.repositories.dao.portalrh.EquipesDao;
import br.com.informa.repositories.dao.portalrh.FeriasDao;
import br.com.informa.repositories.dao.portalrh.TipoDocumentoInternoDao;
import br.com.informa.repositories.dao.portalrh.TipoDocumentoInternoDaoImpl;

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
	
	public GrupoUsuarioDao getGrupoUsuarioDao() {
		return new GrupoUsuarioDaoImpl();
	}
	
	public UsuarioDao getUsuarioDao() {
		return new UsuarioDaoImpl();
	}	
	
	public CargoDao getCargoDao() {
		return new CargoDaoImpl();
	}
	
	public DepartamentoDao getDepartamentoDao() {
		return new DepartamentoDaoImpl();
	}		

	public TipoDocumentoInternoDao getTipoDocumentoInternoDao() {
		return new TipoDocumentoInternoDaoImpl();
	}
	
	public DocumentoInternoDao getDocumentoInternoDao() {
		return new DocumentoInternoDaoImpl();
	}
	
	public ColaboradorDao getColaboradorDao() {
		return new ColaboradorDaoImpl();
	}
	
	public DependentesDao getDependentesDao() {
		return new DependentesDaoImpl();
	}	
	
	public FeriasDao getFeriasDao() {
		return new FeriasDaoImpl();
	}	
	
	public EquipesDao getEquipesDao() {
		return new EquipesDaoImpl();
	}		
	
	public FeriadosDao getFeriadosDao() {
		return new FeriadosDaoImpl();
	}	
	
	public SalaDao getSalaDao() {
		return new SalaDaoImpl();
	}
	
	public MuralDao getMuralDao() {
		return new MuralDaoImpl();
	}	
}
