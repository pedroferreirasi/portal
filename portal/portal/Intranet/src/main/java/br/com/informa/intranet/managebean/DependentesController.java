package br.com.informa.intranet.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.portalrh.Dependentes;
import br.com.informa.negocio.core.FactoryNegocio; 
 
@ManagedBean(name = "dependentesController") 
@ViewScoped 
public class DependentesController extends GenericController<Dependentes, Integer> { 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -1950436289654196982L;

	public DependentesController() { 
		entityService = FactoryNegocio.getFactory().getDependentes(); 
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	@Override
	public void novo() 
	{
		super.novo();
		this.entity = new Dependentes();  
	} 
} 
