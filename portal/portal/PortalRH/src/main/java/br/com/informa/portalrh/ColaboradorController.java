package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.core.GenericController;
import br.com.informa.models.common.Usuario;
import br.com.informa.services.core.FactoryService;

@ManagedBean(name = "colaboradorController")
@ViewScoped
public class ColaboradorController extends GenericController<Usuario, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6576299296092551298L;

	public ColaboradorController() {
		entityService = FactoryService.getFactory().getColaborador();
		this.novo();
		listaEntity = this.getListAll();
		this.setWidthModal("900");
		this.setHeightModal("500");
	}

	@Override
	public void novo() {
		
		super.novo();
		this.entity = new Usuario();					
	}
}
