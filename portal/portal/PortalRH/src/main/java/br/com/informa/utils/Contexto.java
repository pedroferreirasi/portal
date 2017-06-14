package br.com.informa.utils;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import br.com.informa.models.common.Usuario;

public class Contexto implements Serializable {

	private static final long serialVersionUID = 1L;

	public static FacesContext getCurrentFaceContext(){
		return FacesContext.getCurrentInstance();
	}
	
	public static boolean ValidaSeContextoExiste() {
		return FacesContext.getCurrentInstance() != null;
	}
	
	public static Usuario getUsuarioLogoado()
	{
		return (Usuario) getCurrentFaceContext().getExternalContext().getSessionMap().get("ususario");
	}
}
