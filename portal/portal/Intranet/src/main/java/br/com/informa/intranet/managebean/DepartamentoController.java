package br.com.informa.intranet.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.portalrh.Departamento;
import br.com.informa.negocio.core.FactoryNegocio;

@ManagedBean(name = "departamentoController")
@ViewScoped
public class DepartamentoController extends GenericController<Departamento, Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4403618017281531952L;

	public DepartamentoController() {
		entityService = FactoryNegocio.getFactory().getDepartamento();
		listaEntity = this.getListAll();
		this.novo();
	}

	public void novo() {		
		
		super.novo();
		this.entity = new Departamento();		
		this.entity.setAtivo(true);
	}
}