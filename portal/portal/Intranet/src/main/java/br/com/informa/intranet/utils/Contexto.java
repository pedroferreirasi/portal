package br.com.informa.intranet.utils;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.com.informa.intranet.common.AutenticacaoController;
import br.com.informa.models.common.Usuario;

@ManagedBean
@RequestScoped
public class Contexto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Deprecated
	@ManagedProperty(value="#{autenticacaoController.entity}")
	private static Usuario usuarioLogado;

	public static FacesContext getCurrentFaceContext(){
		return FacesContext.getCurrentInstance();
	}
	
	public static boolean ValidaSeContextoExiste() {
		return FacesContext.getCurrentInstance() != null;
	}
	
	public static AutenticacaoController getAutenticacaoController() {
		return (AutenticacaoController) getCurrentFaceContext().getExternalContext().getSessionMap().get("autenticacaoController");
	}
	
	public static Usuario getUsuarioLogado() {
		return getAutenticacaoController().getEntity();
	}
	
	public static Object getContextoViewScoped(String managedBean) {
		return FacesContext.getCurrentInstance().getViewRoot().getViewMap().get(managedBean);
	}
		
	@Deprecated
	@SuppressWarnings("static-access")
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
		
}
