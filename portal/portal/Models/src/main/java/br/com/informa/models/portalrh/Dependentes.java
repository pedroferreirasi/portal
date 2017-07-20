package br.com.informa.models.portalrh;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.EnumType; 
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue; 
import javax.xml.bind.annotation.XmlAccessType; 
import javax.xml.bind.annotation.XmlAccessorType; 
import javax.xml.bind.annotation.XmlRootElement;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.EParentesco;
import java.io.Serializable;
import java.util.Date; 
 
@Entity 
@Table(name="tb_dependentes") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Dependentes implements Serializable {	
 
	public Dependentes() {
		this.dataNascimento = new Date();
	}
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
    @Column(name="pk_depcad", nullable=false, length=10)
    private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_usucad", foreignKey=@ForeignKey(name = "fk_depcad_usucad"))
    private Usuario usuario;

    @Column(name="nome", nullable=true, length=70)
    private String nome;

    @Column(name="parentesco", nullable=true, length=45)
    @Enumerated(EnumType.STRING)
    private EParentesco parentesco;

    @Column(name="datanascimento", nullable=true)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @Column(name="documento", nullable=true, length=20)
    private String documento;

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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public EParentesco getParentesco() {
		return parentesco;
	}

	public void setParentesco(EParentesco parentesco) {
		this.parentesco = parentesco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

}
