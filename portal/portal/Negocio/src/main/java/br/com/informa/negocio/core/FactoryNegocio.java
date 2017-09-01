package br.com.informa.negocio.core;

import br.com.informa.negocio.common.GrupoUsuarioNegocio;
import br.com.informa.negocio.common.GrupoUsuarioNegocioImpl;
import br.com.informa.negocio.common.UsuarioNegocio;
import br.com.informa.negocio.common.UsuarioNegocioImpl;
import br.com.informa.negocio.portal.CargoService;
import br.com.informa.negocio.portal.CargoServiceImpl;
import br.com.informa.negocio.portal.ColaboradorService;
import br.com.informa.negocio.portal.ColaboradorServiceImpl;
import br.com.informa.negocio.portal.DepartamentoService;
import br.com.informa.negocio.portal.DepartamentoServiceImpl;
import br.com.informa.negocio.portal.DependentesService;
import br.com.informa.negocio.portal.DependentesServiceImpl;
import br.com.informa.negocio.portal.DocumentoInternoService;
import br.com.informa.negocio.portal.DocumentoInternoServiceImpl;
import br.com.informa.negocio.portal.EquipesService;
import br.com.informa.negocio.portal.EquipesServiceImpl;
import br.com.informa.negocio.portal.FeriadosService;
import br.com.informa.negocio.portal.FeriadosServiceImpl;
import br.com.informa.negocio.portal.FeriasService;
import br.com.informa.negocio.portal.FeriasServiceImpl;
import br.com.informa.negocio.portal.MuralService;
import br.com.informa.negocio.portal.MuralServiceImpl;
import br.com.informa.negocio.portal.SalaService;
import br.com.informa.negocio.portal.SalaServiceImpl;
import br.com.informa.negocio.portal.TipoDocumentoInternoService;
import br.com.informa.negocio.portal.TipoDocumentoInternoServiceImpl;

public class FactoryNegocio {

	private static FactoryNegocio factory = new FactoryNegocio();

	/*
	 * Um Contrutor privado para previnir que outra classe nao instancie essa
	 */
	private FactoryNegocio() { }
	
	public static FactoryNegocio getFactory() {
		return factory;
	}
	
	public GrupoUsuarioNegocio getGrupoUsuario() {
		return new GrupoUsuarioNegocioImpl();
	}
	
	public UsuarioNegocio getUsuario() {
		return new UsuarioNegocioImpl();
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
	
	public SalaService getSala() {
		return new SalaServiceImpl();
	}	
	
	public MuralService getMural() {
		return new MuralServiceImpl();
	}
}
