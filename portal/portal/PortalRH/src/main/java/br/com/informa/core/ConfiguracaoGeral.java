package br.com.informa.core;

import java.io.Serializable;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name="configuracaoGeral")
@ApplicationScoped
public class ConfiguracaoGeral implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3957623982739534859L;
	
	private String tema;
	
	public ConfiguracaoGeral()
	{
		tema = "omega";
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
