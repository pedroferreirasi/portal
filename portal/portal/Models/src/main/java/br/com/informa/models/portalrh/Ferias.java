package br.com.informa.models.portalrh;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
import javax.xml.bind.annotation.XmlAccessType; 
import javax.xml.bind.annotation.XmlAccessorType; 
import javax.xml.bind.annotation.XmlRootElement;

import br.com.informa.models.common.Usuario;
import br.com.informa.models.dominio.EStatusFerias;
import java.io.Serializable;
import java.util.Date; 
 
@Entity 
@Table(name="tb_ferias") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Ferias implements Serializable {	
 

    /**
	 * 
	 */
	private static final long serialVersionUID = 6064462807032993571L;
	
	public Ferias()
	{
		dataLancamento = new Date();
		dataInicial = new Date();
		dataFinal = new Date();
	}

	@Id
    @GeneratedValue
    @Column(name="pk_fercad", nullable=false, length=10)
    private Integer id;

	@OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name="fk_usucad", unique = false)
    private Usuario usuario;

    @Column(name="data_lancamento", nullable=true, length=0)
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;

    @Column(name="data_inicial", nullable=true, length=0)
    @Temporal(TemporalType.DATE)
    private Date dataInicial;

    @Column(name="data_final", nullable=true, length=0)
    @Temporal(TemporalType.DATE)
    private Date dataFinal;

    @Column(name="dias", nullable=true, length=10)
    private long dias;

    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable=true, length=1)
    private EStatusFerias status;

    @Column(name="aprovacao_gerencia", nullable=true, length=5)
    private String aprovacaoGerencia;

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

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;		
	}

	public long getDias() {
		return dias;
	}

	public void setDias(long dias) {
		this.dias = dias;
	}

	public EStatusFerias getStatus() {
		return status;
	}

	public void setStatus(EStatusFerias status) {
		this.status = status;
	}

	public String getAprovacaoGerencia() {
		return aprovacaoGerencia;
	}

	public void setAprovacaoGerencia(String aprovacaoGerencia) {
		this.aprovacaoGerencia = aprovacaoGerencia;
	}

}