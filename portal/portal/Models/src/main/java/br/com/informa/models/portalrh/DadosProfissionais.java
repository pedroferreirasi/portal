package br.com.informa.models.portalrh;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlAccessType; 
import javax.xml.bind.annotation.XmlAccessorType; 
import javax.xml.bind.annotation.XmlRootElement;

import br.com.informa.models.common.Usuario;

import java.io.Serializable;
import java.util.Calendar; 
 
@Entity 
@Table(name="tb_dados_profissionais") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class DadosProfissionais implements Serializable {	
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 7908641758488184138L;
	
	public DadosProfissionais() {
		flagBatePonto = true;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_procad", nullable=false, length=10)
    private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_usucad")
    private Usuario usuario;

    @Column(name="nuCTPS", nullable=true, length=10)
    private String CTPS;

    @Column(name="serieCTPS", nullable=true, length=10)
    private String serieCTPS;

    @Column(name="ufCTPS", nullable=true, length=2)
    private String estadoCTPS;

    @Column(name="nuPIS", nullable=true, length=15)
    private String PIS;

    @Column(name="emailprofissional", nullable=true, length=70)
    private String emailProfissional;

    @Column(name="telefoneprofissional", nullable=true, length=20)
    private String telefoneProfissional;

    @Column(name="ramal", nullable=true, length=10)
    private String ramal;

    @Column(name="celularprofissional", nullable=true, length=20)
    private String celularProfissional;

    @Column(name="numatricula", nullable=true, length=30)
    private String matricula;

    @Column(name="codigopontoeletronico", nullable=true, length=30)
    private String codigoPontoEletronico;

    @Column(name="flbateponto", nullable=true)
    private Boolean flagBatePonto;

    @Column(name="dataadminissao", nullable=true, length=0)
    @Temporal(TemporalType.DATE)
    private Calendar dataAdmissao;

    @Column(name="cargahoraria", nullable=true, length=10)
    private Integer cargaHoraria;

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

	public String getCTPS() {
		return CTPS;
	}

	public void setCTPS(String cTPS) {
		CTPS = cTPS;
	}

	public String getSerieCTPS() {
		return serieCTPS;
	}

	public void setSerieCTPS(String serieCTPS) {
		this.serieCTPS = serieCTPS;
	}

	public String getEstadoCTPS() {
		return estadoCTPS;
	}

	public void setEstadoCTPS(String estadoCTPS) {
		this.estadoCTPS = estadoCTPS;
	}

	public String getPIS() {
		return PIS;
	}

	public void setPIS(String pIS) {
		PIS = pIS;
	}

	public String getEmailProfissional() {
		return emailProfissional;
	}

	public void setEmailProfissional(String emailProfissional) {
		this.emailProfissional = emailProfissional;
	}

	public String getTelefoneProfissional() {
		return telefoneProfissional;
	}

	public void setTelefoneProfissional(String telefoneProfissional) {
		this.telefoneProfissional = telefoneProfissional;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getCelularProfissional() {
		return celularProfissional;
	}

	public void setCelularProfissional(String celularProfissional) {
		this.celularProfissional = celularProfissional;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getCodigoPontoEletronico() {
		return codigoPontoEletronico;
	}

	public void setCodigoPontoEletronico(String codigoPontoEletronico) {
		this.codigoPontoEletronico = codigoPontoEletronico;
	}

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Boolean getFlagBatePonto() {
		return flagBatePonto;
	}

	public void setFlagBatePonto(Boolean flagBatePonto) {
		this.flagBatePonto = flagBatePonto;
	}

}
