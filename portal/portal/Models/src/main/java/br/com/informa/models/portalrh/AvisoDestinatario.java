package br.com.informa.models.portalrh;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_avdcad", nullable=false)
	@XmlElement
    private Integer id;

	@OneToOne
	@JoinColumn(name="fk_usucad", unique = false, foreignKey=@ForeignKey(name = "fk_avdcad_usucad"))
	@XmlElement
    private Usuario usuario;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fk_avicad", unique = false, foreignKey=@ForeignKey(name = "fk_avdcad_avicad"))
	@XmlElement
    private Aviso aviso;
	
    @Column(name="lido", nullable=false)
    @XmlElement
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
