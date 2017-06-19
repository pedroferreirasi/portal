package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.ViewScoped; 
import br.com.informa.core.GenericController; 
import br.com.informa.models.portalrh.Cargo; 
import br.com.informa.models.dominio.EEstadoForm; 
import br.com.informa.services.core.FactoryService; 
 
@ManagedBean(name = "cargoController") 
@ViewScoped 
public class CargoController extends GenericController<Cargo, Integer> { 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -5449562406432690214L;

	public CargoController() { 
		entityService = FactoryService.getFactory().getCargo(); 
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	public void novo() 
	{ 
		if (this.entity != null) {
			this.entity = null;			
		}
		this.entity = new Cargo(); 
		this.estado = EEstadoForm.Incluir; 
	} 
} 
