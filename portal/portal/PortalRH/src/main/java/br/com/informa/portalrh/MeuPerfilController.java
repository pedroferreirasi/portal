package br.com.informa.portalrh;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.models.common.Usuario;
import br.com.informa.utils.Contexto;

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
	
	public Usuario getEntity() {
		return entity;
	}

	public void setEntity(Usuario entity) {
		this.entity = entity;
	}
	
	
	
}
