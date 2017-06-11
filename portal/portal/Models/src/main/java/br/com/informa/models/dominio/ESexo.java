package br.com.informa.models.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public enum ESexo implements Serializable {
	M("M", "Masculino"),
	F("F", "Feminino");
	
	private String valor = "";
	private String descricao = "";
	
	private ESexo(String valor, String descricao) {
		this.valor = valor;
		this.descricao = descricao;
	}
	
	private ESexo () {}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return getValor().toString();
	}
	
	public static List<ESexo> getListSexo() {
		List<ESexo> listaSexo = new ArrayList<ESexo>();
		
		for (ESexo sexo : ESexo.values()) {
			listaSexo.add(sexo);
		}
		
		return listaSexo;
	}
}
