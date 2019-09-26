package com.cg.contService.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.esotericsoftware.kryo.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="contable")
public class Contable {
	
	
	@NotNull
	@Column(name="periodo_certificacion")
	@JsonFormat(pattern="dd/MM/yyyy")
	@Id
	private Date periodo;
	
	@Column(name="fecha_cierre")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date fecha_cierre;
	
	@Transient
	private long tstamp;
	
	
	public long getTstamp() {
		return periodo.getTime();
	}
	
	public void setTstamp(long tstamp) {
		this.tstamp = tstamp;
	}
	
	public Date getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(Date periodo) {
		this.periodo = periodo;
	}
	
	public Date getFecha_cierre() {
		return fecha_cierre;
	}
	
	public void setFecha_cierre(Date fecha_cierre) {
		this.fecha_cierre = fecha_cierre;
	}

}
