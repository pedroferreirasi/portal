package br.com.informa.portalrh;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.models.common.Usuario;
import br.com.informa.services.core.FactoryService;
import br.com.informa.services.portalrh.ColaboradorService;
import br.com.informa.utils.Contexto;
import br.com.informa.utils.Mensagens;

@ManagedBean(name="meuPerfilController")
@ViewScoped
public class MeuPerfilController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario entity;
	
	public MeuPerfilController()  {
		try {
			this.entity = Contexto.getUsuarioLogado().clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void salvar() {
	    ColaboradorService entityService = FactoryService.getFactory().getColaborador();
		try {
			entityService.Update(this.entity);
			Mensagens.OperacaoRealizadaComSucesso();
		} catch (Exception e) {
			Mensagens.messageError(e.getMessage());
		}		
	}
	
	public Usuario getEntity() {
		return entity;
	}

	public void setEntity(Usuario entity) {
		this.entity = entity;
	}
	
	
	
}
