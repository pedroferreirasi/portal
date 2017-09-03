package br.com.informa.intranet.managebean;

import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.portalrh.Feriados;
import br.com.informa.negocio.core.FactoryNegocio; 
 
@ManagedBean(name = "feriadosController") 
@ViewScoped 
public class FeriadosController extends GenericController<Feriados, Date> { 
 
	private static final long serialVersionUID = 1L;

	public FeriadosController() { 
		entityService = FactoryNegocio.getFactory().getFeriados();
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	public void novo() 
	{ 
		super.novo();
		this.entity = new Feriados(); 	 
	} 
} 
