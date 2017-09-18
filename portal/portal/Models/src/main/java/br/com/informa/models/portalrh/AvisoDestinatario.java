package br.com.informa.models.portalrh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.informa.models.common.Usuario; 
 
@Entity 
@Table(name="tb_avisos_destinatario") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class AvisoDestinatario implements Serializable {	

	public AvisoDestinatario() {
		lido = false;
		this.usuario = new Usuario();
		this.aviso = new Aviso();
	}
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="pk_avdcad", nullable=false)
    private Integer id;

	@OneToOne
	@JoinColumn(name="fk_usucad", unique = false, foreignKey=@ForeignKey(name = "fk_avdcad_usucad"))
    private Usuario usuario;

	@OneToOne
	@JoinColumn(name="fk_avicad", unique = false, foreignKey=@ForeignKey(name = "fk_avdcad_avicad"))
    private Aviso aviso;
	
    @Column(name="lido", nullable=false)
    private Boolean lido;	
    
	public Integer getId() {
		return id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Aviso getAviso() {
		return aviso;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setAviso(Aviso aviso) {
		this.aviso = aviso;
	}

	public Boolean getLido() {
		return lido;
	}

	public void setLido(Boolean lido) {
		this.lido = lido;
	}    

}
