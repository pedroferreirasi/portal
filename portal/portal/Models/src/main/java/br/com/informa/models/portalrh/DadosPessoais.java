package br.com.informa.models.portalrh;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column; 
import javax.persistence.Entity; 
import javax.persistence.EnumType; 
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.xml.bind.annotation.XmlAccessType; 
import javax.xml.bind.annotation.XmlAccessorType; 
import javax.xml.bind.annotation.XmlRootElement;
import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.ETipoLogradouro;
import br.com.informa.models.dominio.EEstadoCivil;
import br.com.informa.models.dominio.EEstadosBrasil;
import java.io.Serializable;
import java.util.Date; 
 
@Entity 
@Table(name="tb_dados_pessoais") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class DadosPessoais implements Serializable {	
 

    /**
	 * 
	 */
	private static final long serialVersionUID = 8033642361287560373L;
	
	public DadosPessoais() {
		this.dataEmissaoRG = new Date();
		this.dataNascimento = new Date();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="pk_pescad", nullable=false, length=10)
    private Integer id;

	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_usucad", insertable=true, updatable=false)
	@PrimaryKeyJoinColumn
	private Usuario usuario;
	
    @Column(name="cep", length=10)
    private String CEP;

    @Column(name="tipologradouro", length=45)
    @Enumerated(EnumType.STRING)
    private ETipoLogradouro tipoLogradouro;

    @Column(name="endereco", length=100)
    private String endereco;

    @Column(name="numero", length=45)
    private String numero;

    @Column(name="complemento", length=45)
    private String complemento;

    @Column(name="bairro", length=100)
    private String bairro;

    @Column(name="cidade", length=45)
    private String cidade;

    @Column(name="estado", length=2)
    @Enumerated(EnumType.STRING)
    private EEstadosBrasil estado;

    @Column(name="nacionalidade", length=45)
    private String nacionalidade;

    @Column(name="naturalidade", length=45)
    private String naturalidade;
    
    @Temporal(TemporalType.DATE)
    @Column(name="datanascimento", columnDefinition="DATE")
    private Date dataNascimento;

    @Column(name="estadocivil", length=1)
    @Enumerated(EnumType.STRING)
    private EEstadoCivil estadoCivil;

    @Column(name="raca", length=45)
    private String raca;

    @Column(name="nomemae", length=100)
    private String nomeMae;

    @Column(name="nomepai", length=100)
    private String nomePai;

    @Column(name="nuRG", length=10)
    private String RG;

    @Column(name="dataemissaoRG", length=0)
    @Temporal(TemporalType.DATE)
    private Date dataEmissaoRG;

    @Column(name="orgaoemissorRG", length=5)
    private String orgaoEmissorRG;

    @Column(name="estadoemissorRG", length=2)
    private String estadoEmissorRG;

    @Column(name="nuCPF", length=15)
    private String CPF;

    @Column(name="emailpessoal", length=70)
    private String emailPessoal;

    @Column(name="telefonepessoal", length=20)
    private String telefonePessoal;

    @Column(name="celularpessoal", length=20)
    private String celularPessoal;

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public EEstadosBrasil getEstado() {
		return estado;
	}

	public void setEstado(EEstadosBrasil estado) {
		this.estado = estado;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EEstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EEstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getRG() {
		return RG;
	}

	public void setRG(String rG) {
		RG = rG;
	}

	public String getOrgaoEmissorRG() {
		return orgaoEmissorRG;
	}

	public void setOrgaoEmissorRG(String orgaoEmissorRG) {
		this.orgaoEmissorRG = orgaoEmissorRG;
	}

	public String getEstadoEmissorRG() {
		return estadoEmissorRG;
	}

	public void setEstadoEmissorRG(String estadoEmissorRG) {
		this.estadoEmissorRG = estadoEmissorRG;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getEmailPessoal() {
		return emailPessoal;
	}

	public void setEmailPessoal(String emailPessoal) {
		this.emailPessoal = emailPessoal;
	}

	public String getTelefonePessoal() {
		return telefonePessoal;
	}

	public void setTelefonePessoal(String telefonePessoal) {
		this.telefonePessoal = telefonePessoal;
	}

	public String getCelularPessoal() {
		return celularPessoal;
	}

	public void setCelularPessoal(String celularPessoal) {
		this.celularPessoal = celularPessoal;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public ETipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(ETipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public Date getDataEmissaoRG() {
		return dataEmissaoRG;
	}

	public void setDataEmissaoRG(Date dataEmissaoRG) {
		this.dataEmissaoRG = dataEmissaoRG;
	}

}
