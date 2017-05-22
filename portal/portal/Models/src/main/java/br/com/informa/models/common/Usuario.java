package br.com.informa.models.common;

import java.util.Calendar;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import br.com.informa.models.dominio.ESexo;
import br.com.informa.models.portalrh.Cargo;
import br.com.informa.models.portalrh.Departamento;

import java.io.Serializable;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5211602883770541991L;
	
	public Usuario() {
		this.grupoUsuario = new GrupoUsuario();
		this.ativo = true;
	}
	

	@Id
	@GeneratedValue
	@Column(name="pk_usucad")
	private int id;
	
	@Column(name="login", nullable=false, length=30, unique=true)
	private String login;	
	
	@Column(name="senha", nullable=false, length=255)
	private String senha;
	
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinColumn(name="fk_usgcad", unique = false, nullable=false)
	private GrupoUsuario grupoUsuario;
	
	@Column(name="nomecompleto", length=100)
	private String nomeCompleto;

	@Column(name="nome", length=30)
	private String nomeUsuario;

	@Column(name="sobrenome", length=30)
	private String sobreNome;	
	
	@Column(name="email", nullable=false, length=70)
	private String email;
	
	@Column(name="sexo", length=1)
	@Enumerated(EnumType.STRING)
	private ESexo sexo;
	
	@Column(name="celular", length=25)
	private String celular;	

	@Temporal(TemporalType.DATE)
	@Column(name="dataCadastro", nullable=false)
	private Calendar dataCadastro;	
	
	@Column(name="ativo", nullable=false)
	private Boolean ativo;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="fk_depcad", unique = false, nullable=false)
	private Departamento departamento;
	
	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="fk_carcad", unique = false, nullable=false)
	private Cargo cargo;	
	
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

	public Calendar getDataCadastro() {		
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public Usuario clone(Usuario entity){
		if (entity == null) 
		{
			entity = new Usuario();
		}
		entity.setAtivo(this.ativo);
		entity.setCelular(this.celular);
		entity.setDataCadastro(this.dataCadastro);
		entity.setEmail(this.email);
		entity.setGrupoUsuario(this.grupoUsuario);
		entity.setId(this.id);
		entity.setLogin(this.login);
		entity.setNomeUsuario(this.nomeUsuario);
		entity.setSexo(this.sexo);
		entity.setSobreNomeUsuario(this.sobreNome);
		entity.setSenha(this.senha);
		
		return entity;
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
	
}
