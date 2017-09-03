package br.com.informa.intranet.managebean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.intranet.core.GenericController;
import br.com.informa.models.portalrh.TipoDocumentoInterno;
import br.com.informa.negocio.core.FactoryNegocio; 
 
@ManagedBean(name = "tipoDocumentoInternoController") 
@ViewScoped 
public class TipoDocumentoInternoController extends GenericController<TipoDocumentoInterno, Integer> { 
 
	private static final long serialVersionUID = 2080656462056665699L;

	public TipoDocumentoInternoController() { 
		entityService = FactoryNegocio.getFactory().getTipoDocumentoInterno(); 
		this.novo(); 
		listaEntity = this.getListAll(); 
	} 
 
	public void novo() 
	{ 
		super.novo();
		this.entity = new TipoDocumentoInterno();  
	} 
} 
