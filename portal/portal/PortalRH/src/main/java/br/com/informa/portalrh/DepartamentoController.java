package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.core.GenericController;
import br.com.informa.models.portalrh.Departamento;
import br.com.informa.services.core.FactoryService;

@ManagedBean(name = "departamentoController")
@ViewScoped
public class DepartamentoController extends GenericController<Departamento, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4403618017281531952L;

	public DepartamentoController() {
		entityService = FactoryService.getFactory().getDepartamento();
		listaEntity = this.getListAll();
		this.novo();
	}

	public void novo() {		
		
		super.novo();
		this.entity = new Departamento();		
		this.entity.setAtivo(true);
	}
}