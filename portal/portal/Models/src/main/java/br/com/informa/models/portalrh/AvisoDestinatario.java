package br.com.informa.models.portalrh;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement; 
 
@Entity 
@Table(name="tb_avisos_destinatario") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class AvisoDestinatario implements Serializable {	

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="pk_avdcad", nullable=false)
    private Integer id;

	@JoinColumn(name="fk_usucad", unique = false, foreignKey=@ForeignKey(name = "fk_avdcad_usucad"))
    private Integer usuario;

	@JoinColumn(name="fk_avicad", unique = false, foreignKey=@ForeignKey(name = "fk_avdcad_avicad"))
    private Integer aviso;
    
	public Integer getId() {
		return id;
	}

	public Integer getUsuario() {
		return usuario;
	}

	public Integer getAviso() {
		return aviso;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}

	public void setAviso(Integer aviso) {
		this.aviso = aviso;
	}    

}
