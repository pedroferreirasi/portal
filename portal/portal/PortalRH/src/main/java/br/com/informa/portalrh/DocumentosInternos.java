package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.core.GenericController;

@ManagedBean(name = "documentosInternosController") 
@ViewScoped 
public class DocumentosInternos extends GenericController<DocumentosInternos, Integer> {
	
	private static final long serialVersionUID = 1L;
	
	public DocumentosInternos() {
		//entityService = FactoryService.getFactory().getDocumentoInterno();
		this.novo(); 
		listaEntity = this.getListAll();
	}
	
	@Override
	public void novo()
	{
		super.novo();
		this.entity = new DocumentosInternos();
	}

}
