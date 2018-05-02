package com.dise.tickets.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TicketRequest {
	
	@NotNull
	private Long idEvent;
	
	@NotNull
	@Pattern(regexp = "CC|CE|PS")
	private String identificationType;
	
	@NotNull
	@Min(value = 1L)
	private Long identification;
	
	@NotNull
	private String names;
	
	@NotNull
	private String surNames;
	
	public TicketRequest() {
		super();
	}
	public Long getIdEvent() {
		return idEvent;
	}
	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}
	
	public String getIdentificationType() {
		return identificationType;
	}
	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}
	public Long getIdentification() {
		return identification;
	}
	public void setIdentification(Long identification) {
		this.identification = identification;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getSurNames() {
		return surNames;
	}
	public void setSurNames(String surNames) {
		this.surNames = surNames;
	}
	
	
	
}
