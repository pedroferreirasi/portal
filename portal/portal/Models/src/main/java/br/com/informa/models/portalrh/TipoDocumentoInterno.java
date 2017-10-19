package br.com.informa.models.portalrh;

import javax.persistence.Table; 
import javax.persistence.Id; 
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.xml.bind.annotation.XmlAccessType; 
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement; 
import java.io.Serializable; 
 
@Entity 
@Table(name="tb_tipodocumentointerno") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class TipoDocumentoInterno implements Serializable {	
    /**
	 * 
	 */
	private static final long serialVersionUID = 8364160662686240757L;

	@Id
    @GeneratedValue
    @Column(name="pk_tdicad", nullable=false, length=10)
	@XmlElement
    private Integer id;

    @Column(name="descricao", nullable=false, length=45)
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
