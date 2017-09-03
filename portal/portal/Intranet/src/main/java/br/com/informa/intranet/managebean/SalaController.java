package br.com.informa.intranet.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.portalrh.Sala;
import br.com.informa.negocio.core.FactoryNegocio;

@ManagedBean(name = "SalaController")
@ViewScoped
public class SalaController extends GenericController<Sala, Integer> {

	private static final long serialVersionUID = 1L;

	public SalaController() {
		entityService = FactoryNegocio.getFactory().getSala();
		this.novo();
		listaEntity = this.getListAll();
	}

	public void novo() 
	{ 
		super.novo();
		this.entity = new Sala(); 
	}
}
