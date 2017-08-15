package br.com.informa.models.portalrh;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.informa.models.common.Usuario; 
 
@Entity 
@Table(name="tb_documentointerno") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class DocumentoInterno implements Serializable {	
 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_docint", nullable=false, length=10)
    private Integer id;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_tdicad", unique = false)
    private TipoDocumentoInterno tipoDocumentoInterno;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_usucad", unique = false)
    private Usuario usuario;

    @Column(name="datacadastro")
    private Date dataCadastro;

    /*@Lob
    @Column(name="texto", nullable=true)
    private byte[] texto;*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TipoDocumentoInterno getTipoDocumentoInterno() {
		return tipoDocumentoInterno;
	}

	public void setTipoDocumentoInterno(TipoDocumentoInterno tipoDocumentoInterno) {
		this.tipoDocumentoInterno = tipoDocumentoInterno;
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

	/*public byte[] getTexto() {
		return texto;
	}

	public void setTexto(byte[] texto) {
		this.texto = texto;
	}*/

}
