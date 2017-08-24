package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.core.GenericController;
import br.com.informa.models.portalrh.TipoDocumentoInterno;
import br.com.informa.services.core.FactoryService; 
 
@ManagedBean(name = "tipoDocumentoInternoController") 
@ViewScoped 
public class TipoDocumentoInternoController extends GenericController<TipoDocumentoInterno, Integer> { 
 
	private static final long serialVersionUID = 2080656462056665699L;

	public TipoDocumentoInternoController() { 
		entityService = FactoryService.getFactory().getTipoDocumentoInterno(); 
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	public void novo() 
	{ 
		super.novo();
		this.entity = new TipoDocumentoInterno();  
	} 
} 
