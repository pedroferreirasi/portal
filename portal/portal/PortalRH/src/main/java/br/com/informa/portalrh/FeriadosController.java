package br.com.informa.portalrh;


import java.util.Date;

import javax.faces.bean.ManagedBean; 
import javax.faces.bean.ViewScoped; 
import br.com.informa.core.GenericController; 
import br.com.informa.models.portalrh.Feriados; 
import br.com.informa.models.dominio.EEstadoForm; 
import br.com.informa.services.core.FactoryService; 
 
@ManagedBean(name = "feriadosController") 
@ViewScoped 
public class FeriadosController extends GenericController<Feriados, Date> { 
 
	private static final long serialVersionUID = 1L;

	public FeriadosController() { 
		entityService = FactoryService.getFactory().getFeriados();
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	public void novo() 
	{ 
		this.entity = new Feriados(); 
		this.estado = EEstadoForm.Incluir; 
	} 
} 
