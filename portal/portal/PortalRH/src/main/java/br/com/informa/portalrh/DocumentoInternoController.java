package br.com.informa.portalrh;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
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
	private File file;

	public DocumentoInternoController() {
		entityService = FactoryService.getFactory().getDocumentoInterno();
		listaEntity = this.getListAll();
	}

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
			file = new File("C:\\Users\\phferreira\\Google Drive\\Documentacao\\In Forma\\Manual do Colaborador Nov2013.pdf");
			
			if (uploadedFile != null) {
				uploadedFile.getFileName();
			}
			
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
	
	public void handleFileUpload(FileUploadEvent event) throws IOException {

	    uploadedFile = event.getFile();
	}

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

}
