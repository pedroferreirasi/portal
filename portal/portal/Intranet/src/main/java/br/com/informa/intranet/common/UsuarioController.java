package br.com.informa.intranet.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.common.Usuario;
import br.com.informa.services.core.FactoryService;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController extends GenericController<Usuario, Integer> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6576299296092551298L;
	
	public UsuarioController() { 
		entityService = FactoryService.getFactory().getUsuario();
		this.novo();
		listaEntity = this.getListAll();
	}
	
	@Override
	public void novo()
	{
		super.novo();
		this.entity = new Usuario();
	}	
}
