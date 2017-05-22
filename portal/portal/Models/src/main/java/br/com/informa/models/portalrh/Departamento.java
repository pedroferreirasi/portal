package br.com.informa.models.portalrh;

import javax.persistence.Table; 
import javax.persistence.Id; 
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.xml.bind.annotation.XmlAccessType; 
import javax.xml.bind.annotation.XmlAccessorType; 
import javax.xml.bind.annotation.XmlRootElement;  
import java.io.Serializable; 
 
@Entity 
@Table(name="tb_departamento") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Departamento implements Serializable {	
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 2539985543970348047L;

	@Id
    @GeneratedValue
    @Column(name="pk_depcad", nullable=false, length=10)
    private Integer id;

    @Column(name="descricao", nullable=false, length=70)
    private String descricao;

    @Column(name="ativo", nullable=false, length=5)
    private boolean ativo;

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

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
