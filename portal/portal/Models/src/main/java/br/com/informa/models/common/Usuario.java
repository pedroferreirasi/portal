package br.com.informa.models.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.informa.models.dominio.ESexo;
import br.com.informa.models.dominio.ETipoUsuario;
import br.com.informa.models.portalrh.Cargo;
import br.com.informa.models.portalrh.DadosPessoais;
import br.com.informa.models.portalrh.DadosProfissionais;
import br.com.informa.models.portalrh.Departamento;
import br.com.informa.models.portalrh.Dependentes;

@Entity
@Table(name = "tb_usuario")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario implements Serializable, Cloneable {

	private static final long serialVersionUID = -5211602883770541991L;
	
	public Usuario() {				
		this.ativo = true;
		this.dataCadastro = new Date();
		
		this.grupoUsuario = new GrupoUsuario();
		this.cargo = new Cargo();
		this.departamento = new Departamento();
		this.dadosPessoais = new DadosPessoais();	
		this.dadosProfissionais = new DadosProfissionais();
		this.getDadosPessoais().setUsuario(this);
		this.getDadosProfissionais().setUsuario(this);
		this.dependentes = new ArrayList<Dependentes>();
	}
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_usucad")
	@XmlElement
	private int id;
	
	@Column(name="login", nullable=false, length=30, unique=true)
	@XmlElement
	private String login;	
	
	@Column(name="senha", nullable=false, length=255)
	@XmlElement
	private String senha;
	
	@Column(name="nomecompleto", length=100)
	@XmlElement
	private String nomeCompleto;

	@Column(name="nome", length=30)
	@XmlElement
	private String nomeUsuario;

	@Column(name="sobrenome", length=30)
	@XmlElement
	private String sobreNome;	
	
	@Column(name="email", nullable=false, length=70)
	@XmlElement
	private String email;
	
	@Column(name="sexo", length=1)
	@Enumerated(EnumType.STRING)
	@XmlElement
	private ESexo sexo;
	
	@Column(name="celular", length=25)
	@XmlElement
	private String celular;	

	@Temporal(TemporalType.DATE)
	@Column(name="dataCadastro", nullable=false)
	@XmlElement
	private Date dataCadastro;	
	
	@Column(name="ativo", nullable=false)
	@XmlElement
	private Boolean ativo;
	
	@Enumerated(EnumType.STRING)
	@Column(name="tipousuario", nullable=false, length=15)
	@XmlElement
	private ETipoUsuario tipoUsuario;	
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_usgcad", unique = false, foreignKey=@ForeignKey(name = "fk_usucad_usgcad"))
	@XmlElement
	private GrupoUsuario grupoUsuario;	

	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name="fk_depcad", unique = false, nullable=true, foreignKey=@ForeignKey(name = "fk_usucad_depcad"))
	@XmlElement
	private Departamento departamento;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="fk_carcad", unique = false, foreignKey=@ForeignKey(name = "fk_usucad_carcad"))
	@XmlElement
	private Cargo cargo;
	
	@OneToOne(mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@XmlElement
	private DadosPessoais dadosPessoais;	

	@OneToOne(mappedBy="usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@XmlElement
	private DadosProfissionais dadosProfissionais;
	
	@OneToMany(mappedBy = "usuario", targetEntity = Dependentes.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Dependentes> dependentes;
	
	
	@Override
    public Usuario clone() throws CloneNotSupportedException {
        return (Usuario) super.clone();
    }
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public GrupoUsuario getGrupoUsuario() {
		return grupoUsuario;
	}

	public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
		this.grupoUsuario = grupoUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getSobreNomeUsuario() {
		return sobreNome;
	}

	public void setSobreNomeUsuario(String sobreNomeUsuario) {
		this.sobreNome = sobreNomeUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ESexo getSexo() {
		return sexo;
	}

	public void setSexo(ESexo sexo) {
		this.sexo = sexo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public Date getDataCadastro() {		
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public DadosProfissionais getDadosProfissionais() {
		return dadosProfissionais;
	}

	public void setDadosProfissionais(DadosProfissionais dadosProfissionais) {
		this.dadosProfissionais = dadosProfissionais;
	}

	public ETipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(ETipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Dependentes> getDependentes() {
		return dependentes;
	}

	public void setDependentes(Dependentes dependentes) {
		this.dependentes.add(dependentes);
	}	
	
}
