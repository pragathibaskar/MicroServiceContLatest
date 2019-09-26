package com.cg.contService.domain;

import java.util.List;


public class Customresponse {
	
	private List<CustomGetResult> provision;
	
	private int totalElements;
	
	
	public List<CustomGetResult> getProvision() {
		return provision;
	}
	public void setProvision(List<CustomGetResult> provision) {
		this.provision = provision;
	}
	public int getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(int totalElements) {
		this.totalElements = totalElements;
	}

}
