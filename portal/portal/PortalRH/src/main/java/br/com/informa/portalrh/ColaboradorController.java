package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.core.GenericController;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.services.core.FactoryService;

@ManagedBean(name = "colaboradorController")
@ViewScoped
public class ColaboradorController extends GenericController<Usuario> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6576299296092551298L;
	
	public ColaboradorController() { 
		entityService = FactoryService.getFactory().getUsuario();
		this.novo();
		listaEntity = this.getListAll();
		this.setWidthModal("60%");
		this.setHeightModal("60%");
	}
	
	public void novo()
	{	
		this.entity = new Usuario();
		this.estado = EEstadoForm.Incluir;
	}	
}
