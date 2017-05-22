package br.com.informa.models.portalrh;

import javax.persistence.Table; 
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue; 
import javax.xml.bind.annotation.XmlAccessType; 
import javax.xml.bind.annotation.XmlAccessorType; 
import javax.xml.bind.annotation.XmlRootElement;

import br.com.informa.models.common.Usuario;

import java.io.Serializable;
import java.util.Calendar; 
 
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
    @GeneratedValue
    @Column(name="pk_docint", nullable=false, length=10)
    private Integer id;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="fk_tdicad", unique = false, nullable=false)
    private TipoDocumentoInterno tipoDocumentoInterno;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="fk_usucad", unique = false, nullable=false)
    private Usuario usuario;

    @Column(name="datacadastro", nullable=false, length=0)
    private Calendar dataCadastro;

    @Lob
    @Column(name="texto", nullable=true, length=65535)
    private String texto;

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

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
