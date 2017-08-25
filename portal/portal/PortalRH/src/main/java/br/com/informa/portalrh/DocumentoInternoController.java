package br.com.informa.portalrh;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

import br.com.informa.core.GenericController;
import br.com.informa.models.portalrh.DocumentoInterno;
import br.com.informa.services.core.FactoryService;
import br.com.informa.utils.Contexto;
import br.com.informa.utils.Mensagens;

@ManagedBean(name = "documentoInternoController")
@ViewScoped
public class DocumentoInternoController extends GenericController<DocumentoInterno, Integer> {

	private static final long serialVersionUID = 1L;

	private UploadedFile uploadedFile;

	public DocumentoInternoController() {
		entityService = FactoryService.getFactory().getDocumentoInterno();
		listaEntity = this.getListAll();
	}

	/*
	 * try { File file = new File(uploadedFile.getFileName());
	 * 
	 * OutputStream out = new FileOutputStream(file);
	 * out.write(uploadedFile.getContents()); out.close();
	 * 
	 * FacesContext.getCurrentInstance().addMessage( null, new
	 * FacesMessage("Upload completo", "O arquivo " + uploadedFile.getFileName()
	 * + " foi salvo!")); } catch(IOException e) {
	 * FacesContext.getCurrentInstance().addMessage( null, new
	 * FacesMessage(FacesMessage.SEVERITY_WARN, "Erro", e.getMessage())); }
	 */

	@Override
	public void novo() {
		super.novo();

		this.entity = new DocumentoInterno();
		this.entity.setUsuario(Contexto.getUsuarioLogado());
	}

	@Override
	public void salvar() {
		try {
			//File file = new File(uploadedFile.getFileName());
			File file = new File("C:\\Users\\phferreira\\Google Drive\\Documentacao\\In Forma\\Manual do Colaborador Nov2013.pdf");
			
			/*if (uploadedFile != null) {
				String teste = uploadedFile.getFileName();
			}*/
			
			byte[] bFile = new byte[(int) file.length()];

			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();

			this.entity.setTexto(bFile);
			super.salvar();
		} catch (IOException e) {
			Mensagens.messageError(e.getMessage());
		} catch (Exception e) {
			Mensagens.messageError(e.getMessage());
		}
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

}
