package br.com.informa.intranet.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.common.Usuario;
import br.com.informa.negocio.core.FactoryNegocio;

@ManagedBean(name = "ramaisController")
@ViewScoped
public class RamaisController extends GenericController<Usuario, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6576299296092551298L;

	public RamaisController() {
		entityService = FactoryNegocio.getFactory().getColaborador();
		this.novo();
		listaEntity = this.getListAll();
		this.setWidthModal("600");
		this.setHeightModal("280");
		this.setExibeBotaoExcluir(false);
		this.setExibeBotaoCancelar(false);
		this.setExibeBotaoSalvar(false);
		this.setExibeBotaoNovo(false);
		this.setExibeBotaoAtualizar(false);
	}

	public void novo() {
		super.novo();	
		this.entity = new Usuario();
	}
}
