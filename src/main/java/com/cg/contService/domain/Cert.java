package com.cg.contService.domain;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Cert {

	@JsonFormat(pattern="dd/MM/yyyy")
	private Date periodo;
	
	private String codigo;
	
	private long tstamp;
	
    private String status;
    

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private enum status{
		EnCurso,
		Tramitada,
		Denegada
	}

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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
