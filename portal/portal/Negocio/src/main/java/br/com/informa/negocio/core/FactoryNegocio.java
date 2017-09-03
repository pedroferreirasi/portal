package br.com.informa.negocio.core;

import br.com.informa.negocio.common.GrupoUsuarioNegocio;
import br.com.informa.negocio.common.GrupoUsuarioNegocioImpl;
import br.com.informa.negocio.common.UsuarioNegocio;
import br.com.informa.negocio.common.UsuarioNegocioImpl;
import br.com.informa.negocio.portal.CargoNegocio;
import br.com.informa.negocio.portal.CargoNegocioImpl;
import br.com.informa.negocio.portal.ColaboradorNegocio;
import br.com.informa.negocio.portal.ColaboradorNegocioImpl;
import br.com.informa.negocio.portal.DepartamentoNegocio;
import br.com.informa.negocio.portal.DepartamentoNegocioImpl;
import br.com.informa.negocio.portal.DependentesNegocio;
import br.com.informa.negocio.portal.DependentesNegocioImpl;
import br.com.informa.negocio.portal.DocumentoInternoNegocio;
import br.com.informa.negocio.portal.DocumentoInternoNegocioImpl;
import br.com.informa.negocio.portal.EquipesNegocio;
import br.com.informa.negocio.portal.EquipesNegocioImpl;
import br.com.informa.negocio.portal.FeriadosNegocio;
import br.com.informa.negocio.portal.FeriadosNegocioImpl;
import br.com.informa.negocio.portal.FeriasNegocio;
import br.com.informa.negocio.portal.FeriasNegocioImpl;
import br.com.informa.negocio.portal.MuralNegocio;
import br.com.informa.negocio.portal.MuralNegocioImpl;
import br.com.informa.negocio.portal.SalaNegocio;
import br.com.informa.negocio.portal.SalaNegocioImpl;
import br.com.informa.negocio.portal.TipoDocumentoInternoNegocio;
import br.com.informa.negocio.portal.TipoDocumentoInternoNegocioImpl;

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
	
	public CargoNegocio getCargo() {
		return new CargoNegocioImpl();
	}
	
	public DepartamentoNegocio getDepartamento() {
		return new DepartamentoNegocioImpl();
	}	
	
	public TipoDocumentoInternoNegocio getTipoDocumentoInterno() {
		return new TipoDocumentoInternoNegocioImpl();
	}		
	
	public DocumentoInternoNegocio getDocumentoInterno() {
		return new DocumentoInternoNegocioImpl();
	}
	
	public ColaboradorNegocio getColaborador() {
		return new ColaboradorNegocioImpl();
	}
	
	public DependentesNegocio getDependentes() {
		return new DependentesNegocioImpl();
	}	
	
	public FeriasNegocio getFerias() {
		return new FeriasNegocioImpl();
	}	
	
	public EquipesNegocio getEquipes() {
		return new EquipesNegocioImpl();
	}	
	
	public FeriadosNegocio getFeriados() {
		return new FeriadosNegocioImpl();
	}	
	
	public SalaNegocio getSala() {
		return new SalaNegocioImpl();
	}	
	
	public MuralNegocio getMural() {
		return new MuralNegocioImpl();
	}
}
