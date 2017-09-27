package br.com.informa.intranet.managebean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.intranet.utils.Contexto;
import br.com.informa.models.portalrh.AvisoDestinatario;
import br.com.informa.negocio.core.FactoryNegocio;
import br.com.informa.negocio.portal.AvisoDestinatarioNegocio;

@ManagedBean(name="mainMenuController")
@ViewScoped
public class MainMenuController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer avisosNaoLidos;
	private List<AvisoDestinatario> listaAvisosNaoLidos;
	
	public MainMenuController() {
		AvisoDestinatarioNegocio entityNegocio = FactoryNegocio.getFactory().getAvisoDestinatario();
		listaAvisosNaoLidos = entityNegocio.getAvisosNaoLido(Contexto.getUsuarioLogado().getId());
		if (listaAvisosNaoLidos != null) {
			this.avisosNaoLidos = listaAvisosNaoLidos.size();
		} else {
			this.avisosNaoLidos = 0;
		}
		
	}

	public Integer getAvisosNaoLidos() {
		return avisosNaoLidos;
	}

	public void setAvisosNaoLidos(Integer avisosNaoLidos) {
		this.avisosNaoLidos = avisosNaoLidos;
	}

	public List<AvisoDestinatario> getListaAvisosNaoLidos() {
		return listaAvisosNaoLidos;
	}

	public void setListaAvisosNaoLidos(List<AvisoDestinatario> listaAvisosNaoLidos) {
		this.listaAvisosNaoLidos = listaAvisosNaoLidos;
	}
	
	

}
