package br.com.informa.models.common;

import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.informa.models.dominio.ETipoGrupoUsuario;

import javax.xml.bind.annotation.XmlElement;

import java.io.Serializable;

@Entity
@Table(name="tb_grupousuario")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GrupoUsuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6465782543541012902L;

	@Id
	@GeneratedValue
	@Column(name="pk_usgcad")
	@XmlElement
	private int id;
	
	@Column(name="descricao", nullable=false, length=70)
	@XmlElement
	private String descricao;
	
	@Column(name="tp_grupousuario", nullable=false, length=20)
	@XmlElement
	@Enumerated(EnumType.STRING)
	private ETipoGrupoUsuario tipoGrupoUsuario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ETipoGrupoUsuario getTipoGrupoUsuario() {
		return tipoGrupoUsuario;
	}

	public void setTipoGrupoUsuario(ETipoGrupoUsuario tipoGrupoUsuario) {
		this.tipoGrupoUsuario = tipoGrupoUsuario;
	}
	
}
