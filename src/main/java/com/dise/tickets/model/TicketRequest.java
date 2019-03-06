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
	private String identification;
	
	@NotNull
	private String names;
	
	@NotNull
	private String surNames;
	
	@NotNull
	private int quantity;
	
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
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
