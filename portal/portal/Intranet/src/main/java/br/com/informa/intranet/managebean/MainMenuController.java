package br.com.informa.intranet.managebean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.informa.intranet.utils.Contexto;
import br.com.informa.models.portalrh.Aviso;
import br.com.informa.negocio.core.FactoryNegocio;
import br.com.informa.negocio.portal.AvisoNegocio;

@ManagedBean(name="mainMenuController")
@ViewScoped
public class MainMenuController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer avisosNaoLidos;
	private List<Aviso> listaAvisosNaoLidos;
	
	public MainMenuController() {
		/*AvisoNegocio entityNegocio = FactoryNegocio.getFactory().getAviso();
		listaAvisosNaoLidos = entityNegocio.getAvisosNaoLido(Contexto.getUsuarioLogado().getId());
		if (listaAvisosNaoLidos != null) {
			this.avisosNaoLidos = listaAvisosNaoLidos.size();
		}*/
		this.avisosNaoLidos = 0;
		
	}

	public Integer getAvisosNaoLidos() {
		return avisosNaoLidos;
	}

	public void setAvisosNaoLidos(Integer avisosNaoLidos) {
		this.avisosNaoLidos = avisosNaoLidos;
	}

	public List<Aviso> getListaAvisosNaoLidos() {
		return listaAvisosNaoLidos;
	}

	public void setListaAvisosNaoLidos(List<Aviso> listaAvisosNaoLidos) {
		this.listaAvisosNaoLidos = listaAvisosNaoLidos;
	}
	
	

}
