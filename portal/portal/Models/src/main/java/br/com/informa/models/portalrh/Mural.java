package br.com.informa.models.portalrh;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.informa.models.common.Usuario; 
 
@Entity 
@Table(name="tb_mural") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Mural implements Serializable {	
 
	private static final long serialVersionUID = 1L;
	
	public Mural() {
		this.dataCadastro = new Date();
		this.usuario = new Usuario();
	}

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_murcad")
    private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_usucad", unique = false, foreignKey=@ForeignKey(name = "fk_murcad_usucad"))
    private Usuario usuario;

    @Column(name="dataCadastro", nullable=false, length=0)
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(name="texto")
    private String texto;

    @Lob
    @Column(name="imagem")
    private byte[] imagem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

}