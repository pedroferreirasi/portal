package br.com.informa.models.portalrh;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement; 
 
@Entity 
@Table(name="tb_salas") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Sala implements Serializable {	
 
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="pk_salcad", nullable=false, length=10)
	@XmlElement
    private Integer id;

    @Column(name="descricao", nullable=true, length=70)
    @XmlElement
    private String descricao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
    
    

}
