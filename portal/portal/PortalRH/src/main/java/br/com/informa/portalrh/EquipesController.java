package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.ViewScoped; 
import br.com.informa.core.GenericController; 
import br.com.informa.models.portalrh.Equipes; 
import br.com.informa.models.dominio.EEstadoForm; 
import br.com.informa.services.core.FactoryService; 
 
@ManagedBean(name = "EquipesController") 
@ViewScoped 
public class EquipesController extends GenericController<Equipes, Integer> { 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7271909365387713375L;

	public EquipesController() { 
		entityService = FactoryService.getFactory().getEquipes(); 
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	public void novo() 
	{ 
		this.entity = new Equipes(); 
		this.estado = EEstadoForm.Incluir; 
	} 
} 
