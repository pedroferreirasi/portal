package br.com.informa.models.portalrh;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.informa.models.common.Usuario; 
 
@Entity 
@Table(name="tb_avisos") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Aviso implements Serializable {	
 
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="pk_avicad", nullable=false)
    private Integer id;

	@JoinColumn(name="fk_usucad_envio", unique = false, foreignKey=@ForeignKey(name = "fk_avicad_usucad"))	
    private Usuario usuario;

    @Column(name="dataCadastro", nullable=false, length=0)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(name="titulo", nullable=false, length=255)
    private String titulo;

    @Column(name="mensagem", nullable=false, length=-1)
    private String mensagem;

    @Column(name="dataValidade", nullable=true, length=0)
    @Temporal(TemporalType.DATE)
    private Date dataValidade;

	public Integer getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}
    
    

}
