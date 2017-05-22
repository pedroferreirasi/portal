package br.com.informa.portalrh;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "documentosInternosController") 
@ViewScoped 
public class DocumentosInternos {
	
	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
