package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.core.GenericController;
import br.com.informa.models.portalrh.Departamento;
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.services.core.FactoryService;

@ManagedBean(name = "departamentoController")
@ViewScoped
public class DepartamentoController extends GenericController<Departamento> {

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
		if (this.entity == null) {
			this.entity = new Departamento();
		}
		this.estado = EEstadoForm.Incluir;
		this.entity.setAtivo(true);
	}
}
