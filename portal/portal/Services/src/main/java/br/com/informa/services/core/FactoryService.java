package br.com.informa.services.core;

import br.com.informa.services.common.GrupoUsuarioService;
import br.com.informa.services.common.GrupoUsuarioServiceImpl;
import br.com.informa.services.common.UsuarioService;
import br.com.informa.services.common.UsuarioServiceImpl;
import br.com.informa.services.portalrh.CargoServiceImpl;
import br.com.informa.services.portalrh.ColaboradorServiceImpl;
import br.com.informa.services.portalrh.DepartamentoServiceImpl;
import br.com.informa.services.portalrh.DependentesServiceImpl;
import br.com.informa.services.portalrh.DocumentoInternoServiceImpl;
import br.com.informa.services.portalrh.EquipesServiceImpl;
import br.com.informa.services.portalrh.FeriadosService;
import br.com.informa.services.portalrh.FeriadosServiceImpl;
import br.com.informa.services.portalrh.FeriasServiceImpl;
import br.com.informa.services.portalrh.CargoService;
import br.com.informa.services.portalrh.ColaboradorService;
import br.com.informa.services.portalrh.DepartamentoService;
import br.com.informa.services.portalrh.DependentesService;
import br.com.informa.services.portalrh.DocumentoInternoService;
import br.com.informa.services.portalrh.EquipesService;
import br.com.informa.services.portalrh.FeriasService;
import br.com.informa.services.portalrh.TipoDocumentoInternoService;
import br.com.informa.services.portalrh.TipoDocumentoInternoServiceImpl;

public class FactoryService {

	private static FactoryService factory = new FactoryService();

	/*
	 * Um Contrutor privado para previnir que outra classe nao instancie essa
	 */
	private FactoryService() { }
	
	public static FactoryService getFactory() {
		return factory;
	}
	
	public GrupoUsuarioService getGrupoUsuario() {
		return new GrupoUsuarioServiceImpl();
	}
	
	public UsuarioService getUsuario() {
		return new UsuarioServiceImpl();
	}
	
	public CargoService getCargo() {
		return new CargoServiceImpl();
	}
	
	public DepartamentoService getDepartamento() {
		return new DepartamentoServiceImpl();
	}	
	
	public TipoDocumentoInternoService getTipoDocumentoInterno() {
		return new TipoDocumentoInternoServiceImpl();
	}		
	
	public DocumentoInternoService getDocumentoInterno() {
		return new DocumentoInternoServiceImpl();
	}
	
	public ColaboradorService getColaborador() {
		return new ColaboradorServiceImpl();
	}
	
	public DependentesService getDependentes() {
		return new DependentesServiceImpl();
	}	
	
	public FeriasService getFerias() {
		return new FeriasServiceImpl();
	}	
	
	public EquipesService getEquipes() {
		return new EquipesServiceImpl();
	}	
	
	public FeriadosService getFeriados() {
		return new FeriadosServiceImpl();
	}		
}
