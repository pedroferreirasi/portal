package br.com.informa.models.portalrh;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement; 
 
@Entity 
@Table(name="feriados") 
@XmlRootElement 
@XmlAccessorType(XmlAccessType.FIELD) 
public class Feriados implements Serializable {	
 
	private static final long serialVersionUID = 1L;
    
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pk_fercad")
	@XmlElement
	private int id;

	@Column(name="nome", nullable=true, length=50)
	@XmlElement
    private String descricao;

    @Column(name="data_feriado", nullable=false, length=0)
    @Temporal(TemporalType.DATE)
    @XmlElement
    private Date dataFeriado;

    @Column(name="meiodia", nullable=false, length=3)
    @Temporal(TemporalType.DATE)
    @XmlElement
    private Date meioDia;

    @Column(name="horas_consideradas", nullable=false, length=10)
    @XmlElement
    private Integer horasConsideradas;

    @Column(name="minutos_considerados", nullable=false, length=10)
    @XmlElement
    private Integer minutosConsiderados;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataFeriado() {
		return dataFeriado;
	}

	public void setDataFeriado(Date dataFeriado) {
		this.dataFeriado = dataFeriado;
	}

	public Date getMeioDia() {
		return meioDia;
	}

	public void setMeioDia(Date meioDia) {
		this.meioDia = meioDia;
	}

	public Integer getHorasConsideradas() {
		return horasConsideradas;
	}

	public void setHorasConsideradas(Integer horasConsideradas) {
		this.horasConsideradas = horasConsideradas;
	}

	public Integer getMinutosConsiderados() {
		return minutosConsiderados;
	}

	public void setMinutosConsiderados(Integer minutosConsiderados) {
		this.minutosConsiderados = minutosConsiderados;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
