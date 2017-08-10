package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.ViewScoped; 
import br.com.informa.core.GenericController; 
import br.com.informa.models.portalrh.Dependentes; 
import br.com.informa.models.dominio.EEstadoForm; 
import br.com.informa.services.core.FactoryService; 
 
@ManagedBean(name = "dependentesController") 
@ViewScoped 
public class DependentesController extends GenericController<Dependentes, Integer> { 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -1950436289654196982L;

	public DependentesController() { 
		entityService = FactoryService.getFactory().getDependentes(); 
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	public void novo() 
	{
		if (this.entity != null) {
			this.entity = null;
		}
		this.entity = new Dependentes(); 
		this.estado = EEstadoForm.Incluir; 
	} 
} 
