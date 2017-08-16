package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.core.GenericController;
import br.com.informa.models.portalrh.DocumentoInterno;
import br.com.informa.services.core.FactoryService;
import br.com.informa.utils.Contexto; 
 
@ManagedBean(name = "documentoInternoController") 
@ViewScoped 
public class DocumentoInternoController extends GenericController<DocumentoInterno, Integer> { 
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1857791039787747741L;

	public DocumentoInternoController() { 
		entityService = FactoryService.getFactory().getDocumentoInterno(); 
		this.novo(); 
		listaEntity = this.getListAll();
		//getMissao();
	} 
 
	@Override
	public void novo() 
	{ 
		super.novo();
		
		this.entity = new DocumentoInterno(); 
		this.entity.setUsuario(Contexto.getUsuarioLogado());
	} 
	
	public void getMissao() {
		this.entity = entityService.getById(1);
	}
} 
