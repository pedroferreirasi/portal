package br.com.informa.models.portalrh;

import javax.persistence.Table; 
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue; 
import javax.xml.bind.annotation.XmlAccessType; 
import javax.xml.bind.annotation.XmlAccessorType; 
import javax.xml.bind.annotation.XmlRootElement;
import br.com.informa.models.common.Usuario; 
import java.io.Serializable; 
 
@Entity 
@Table(name="equipes") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Equipes implements Serializable {	
 

    /**
	 * 
	 */
	private static final long serialVersionUID = 2565968544916054853L;

	@Id
    @GeneratedValue    
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="cod_gerente_fk", unique = false, foreignKey=@ForeignKey(name = "fk_eqpcad_usucad_1"))	
    private Usuario gerente;

    @Id
    @GeneratedValue    
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="cod_subordinado_fk", unique = false, foreignKey=@ForeignKey(name = "fk_eqpcad_usucad_2"))
    private Usuario usuario;

	public Usuario getGerente() {
		return gerente;
	}

	public void setGerente(Usuario gerente) {
		this.gerente = gerente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
