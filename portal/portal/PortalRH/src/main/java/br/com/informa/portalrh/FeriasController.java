package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.ViewScoped; 
import br.com.informa.core.GenericController; 
import br.com.informa.models.portalrh.Ferias; 
import br.com.informa.models.dominio.EEstadoForm;
import br.com.informa.services.core.FactoryService; 
 
@ManagedBean(name = "feriasController") 
@ViewScoped 
public class FeriasController extends GenericController<Ferias> { 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -912029647217710627L;

	public FeriasController() { 
		entityService = FactoryService.getFactory().getFerias(); 
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	public void novo() 
	{ 
		this.entity = new Ferias(); 
		this.estado = EEstadoForm.Incluir; 
	} 
	
	public void calculaDias()
	{
		this.entity.setDias(this.entity.getDataFinal().getTime() - this.entity.getDataInicial().getTime());
	}
} 
