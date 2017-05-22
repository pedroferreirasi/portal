package br.com.informa.common;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.core.GenericController;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.EstadoForm;
import br.com.informa.services.core.FactoryService;

@ManagedBean(name = "usuarioController")
@ViewScoped
public class UsuarioController extends GenericController<Usuario> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6576299296092551298L;
	
	public UsuarioController() { 
		entityService = FactoryService.getFactory().getUsuario();
		this.novo();
		listaEntity = this.getListAll();
	}
	
	public void novo()
	{	
		this.entity = new Usuario();
		this.estado = EstadoForm.Incluir;
	}	
}
