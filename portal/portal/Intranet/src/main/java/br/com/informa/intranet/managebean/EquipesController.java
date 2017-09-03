package br.com.informa.intranet.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.portalrh.Equipes;
import br.com.informa.negocio.core.FactoryNegocio; 
 
@ManagedBean(name = "EquipesController") 
@ViewScoped 
public class EquipesController extends GenericController<Equipes, Integer> { 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7271909365387713375L;

	public EquipesController() { 
		entityService = FactoryNegocio.getFactory().getEquipes(); 
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	public void novo() 
	{ 
		super.novo();
		this.entity = new Equipes();  
	} 
} 
