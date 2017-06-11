package br.com.informa.models.dominio;

import java.io.Serializable;

public enum ESexo implements Serializable {
	M("M", "Masculino"),
	F("F", "Feminino");
	
	private String nome = "";
	private String descricao = "";
	
	private ESexo(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}
	
	private ESexo () {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return getNome().toString();
	}
}
