package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.core.GenericController;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.services.core.FactoryService;

@ManagedBean(name = "ramaisController")
@ViewScoped
public class RamaisController extends GenericController<Usuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6576299296092551298L;

	public RamaisController() {
		entityService = FactoryService.getFactory().getColaborador();
		this.novo();
		listaEntity = this.getListAll();
		this.setWidthModal("600");
		this.setHeightModal("280");
		this.setExibeBotaoExcluir(false);
		this.setExibeBotaoCancelar(false);
		this.setExibeBotaoSalvar(false);
	}

	public void novo() {
		if (this.entity == null) {
			this.entity = new Usuario();
		}
		this.estado = EEstadoForm.Incluir;
	}
}
