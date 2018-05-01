package com.dise.tickets.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class TicketPk implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Column(name="id_event")
	private Long idSocialEvent;
	
	@Column(name="id_ticket")
	private String idTicket;

	public TicketPk() {
		super();
	}

	public TicketPk(Long idSocialEvent, String idTicket) {
		super();
		this.idSocialEvent = idSocialEvent;
		this.idTicket = idTicket;
	}

	public Long getIdSocialEvent() {
		return idSocialEvent;
	}

	public void setIdSocialEvent(Long idSocialEvent) {
		this.idSocialEvent = idSocialEvent;
	}

	public String getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(String idTicket) {
		this.idTicket = idTicket;
	}
	
}
