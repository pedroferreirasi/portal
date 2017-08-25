package br.com.informa.portalrh;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

import br.com.informa.core.GenericController;
import br.com.informa.models.portalrh.DocumentoInterno;
import br.com.informa.services.core.FactoryService;
import br.com.informa.utils.Contexto; 
 
@ManagedBean(name = "documentoInternoController") 
@ViewScoped 
public class DocumentoInternoController extends GenericController<DocumentoInterno, Integer> { 
 
	private static final long serialVersionUID = 1L;
	
	private UploadedFile uploadedFile;

	public DocumentoInternoController() { 
		entityService = FactoryService.getFactory().getDocumentoInterno(); 
		//this.novo(); 
		listaEntity = this.getListAll();
		//getMissao();
	} 
 
	@Override
	public void novo() 
	{ 
		super.novo();
		
		this.entity = new DocumentoInterno(); 
		this.entity.setUsuario(Contexto.getUsuarioLogado());
		/*
		  try {
			    File file = new File(uploadedFile.getFileName());

			    OutputStream out = new FileOutputStream(file);
			    out.write(uploadedFile.getContents());
			    out.close();
			 
			    FacesContext.getCurrentInstance().addMessage(
			               null, new FacesMessage("Upload completo", 
			               "O arquivo " + uploadedFile.getFileName() + " foi salvo!"));
			  } catch(IOException e) {
			    FacesContext.getCurrentInstance().addMessage(
			              null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage()));
			  }*/		
	} 
	
} 
