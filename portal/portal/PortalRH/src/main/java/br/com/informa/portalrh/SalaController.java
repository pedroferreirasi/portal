package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.core.GenericController;
import br.com.informa.models.portalrh.Sala;
import br.com.informa.services.core.FactoryService;

@ManagedBean(name = "SalaController")
@ViewScoped
public class SalaController extends GenericController<Sala, Integer> {

	private static final long serialVersionUID = 1L;

	public SalaController() {
		entityService = FactoryService.getFactory().getSala();
		this.novo();
		listaEntity = this.getListAll();
	}

	public void novo() 
	{ 
		super.novo();
		this.entity = new Sala(); 
	}
}
