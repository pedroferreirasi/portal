package br.com.informa.intranet.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.portalrh.Cargo;
import br.com.informa.negocio.core.FactoryNegocio; 
 
@ManagedBean(name = "cargoController") 
@ViewScoped 
public class CargoController extends GenericController<Cargo, Integer> { 
 
	private static final long serialVersionUID = -5449562406432690214L;

	public CargoController() { 
		entityService = FactoryNegocio.getFactory().getCargo(); 
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	@Override
	public void novo() 
	{ 
		super.novo();
		this.entity = new Cargo(); 		
	} 
} 
