package br.com.informa.services.core;

import br.com.informa.services.common.IGrupoUsuarioService;
import br.com.informa.services.common.GrupoUsuarioService;
import br.com.informa.services.common.IUsuarioService;
import br.com.informa.services.common.UsuarioService;
import br.com.informa.services.portalrh.CargoService;
import br.com.informa.services.portalrh.ColaboradorService;
import br.com.informa.services.portalrh.DepartamentoService;
import br.com.informa.services.portalrh.DocumentoInternoService;
import br.com.informa.services.portalrh.ICargoService;
import br.com.informa.services.portalrh.IColaboradorService;
import br.com.informa.services.portalrh.IDepartamentoService;
import br.com.informa.services.portalrh.IDocumentoInternoService;
import br.com.informa.services.portalrh.ITipoDocumentoInternoService;
import br.com.informa.services.portalrh.TipoDocumentoInternoService;

public class FactoryService {

	private static FactoryService factory = new FactoryService();

	/*
	 * Um Contrutor privado para previnir que outra classe nao instancie essa
	 */
	private FactoryService() { }
	
	public static FactoryService getFactory() {
		return factory;
	}
	
	public IGrupoUsuarioService getGrupoUsuario() {
		return new GrupoUsuarioService();
	}
	
	public IUsuarioService getUsuario() {
		return new UsuarioService();
	}
	
	public ICargoService getCargo() {
		return new CargoService();
	}
	
	public IDepartamentoService getDepartamento() {
		return new DepartamentoService();
	}	
	
	public ITipoDocumentoInternoService getTipoDocumentoInterno() {
		return new TipoDocumentoInternoService();
	}		
	
	public IDocumentoInternoService getDocumentoInterno() {
		return new DocumentoInternoService();
	}
	
	public IColaboradorService getColaborador() {
		return new ColaboradorService();
	}	
}
