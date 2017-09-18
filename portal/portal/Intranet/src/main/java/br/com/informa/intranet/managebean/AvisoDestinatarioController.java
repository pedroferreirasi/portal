package br.com.informa.intranet.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.models.portalrh.AvisoDestinatario;
import br.com.informa.negocio.core.FactoryNegocio;

@ManagedBean(name = "AvisoDestinatarioController")
@ViewScoped
public class AvisoDestinatarioController extends GenericController<AvisoDestinatario, Integer> {

	private static final long serialVersionUID = 1L;

	public AvisoDestinatarioController() {
		entityService = FactoryNegocio.getFactory().getAvisoDestinatario();
		this.novo();
		listaEntity = this.getListAll();
	}

	public void novo() {
		if (this.entity != null) {
			this.entity = null;
		}
		this.entity = new AvisoDestinatario();
		this.estado = EEstadoForm.Incluir;
	}
}
