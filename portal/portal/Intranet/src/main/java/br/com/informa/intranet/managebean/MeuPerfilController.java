package br.com.informa.intranet.managebean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import br.com.informa.models.common.Usuario;
import br.com.informa.negocio.core.FactoryNegocio;
import br.com.informa.negocio.portal.ColaboradorNegocio;
import br.com.informa.intranet.utils.Contexto;
import br.com.informa.intranet.utils.Mensagens;

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
	    ColaboradorNegocio entityService = FactoryNegocio.getFactory().getColaborador();
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
