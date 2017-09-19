package br.com.informa.models.portalrh;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.informa.models.common.Usuario; 
 
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
		this.dataAdmissao = new Date();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_procad", length=10)
    private Integer id;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="fk_usucad", unique = false, foreignKey=@ForeignKey(name = "fk_procad_usucad"))
    private Usuario usuario;

    @Column(name="nuCTPS", length=10)
    private String CTPS;

    @Column(name="serieCTPS", length=10)
    private String serieCTPS;

    @Column(name="ufCTPS", length=2)
    private String estadoCTPS;

    @Column(name="nuPIS", length=15)
    private String PIS;

    @Column(name="emailprofissional", length=70)
    private String emailProfissional;

    @Column(name="telefoneprofissional", length=20)
    private String telefoneProfissional;

    @Column(name="ramal", length=10)
    private String ramal;

    @Column(name="celularprofissional", length=20)
    private String celularProfissional;

    @Column(name="numatricula", length=30)
    private String matricula;

    @Column(name="codigopontoeletronico", length=30)
    private String codigoPontoEletronico;

    @Column(name="flbateponto")
    private Boolean flagBatePonto;

    @Column(name="dataadminissao")
    @Temporal(TemporalType.DATE)
    private Date dataAdmissao;

    @Column(name="cargahoraria", length=10)
    private Integer cargaHoraria;
    
    @Column(name="banco", length=45)
    private String banco;
    
    @Column(name="agencia", length=10)
    private String agencia;
    
    @Column(name="conta", length=10)
    private String conta;
    
   // @OneToOne
    @Column(name="fk_procad_chefia", length=10)
	//@JoinColumn(name="fk_procad_chefia", unique = false, foreignKey=@ForeignKey(name = "fk_procad_procad"))
    private Integer chefia;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@PrimaryKeyJoinColumn
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

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
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

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Integer getChefia() {
		return chefia;
	}

	public void setChefia(Integer chefia) {
		this.chefia = chefia;
	}

}
