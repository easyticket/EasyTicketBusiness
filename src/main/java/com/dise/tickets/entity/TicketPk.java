package com.dise.tickets.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TicketPk implements Serializable{

	private static final long serialVersionUID = 1L;

	
	@Column(name="id_social_event")
	private Long idSocialEvent;
	
	@Column(name="ticket_number")
	private Long ticketNumber;

	
	public TicketPk() {
		super();
	}

	public TicketPk(Long idSocialEvent, Long ticketNumber) {
		super();
		this.idSocialEvent = idSocialEvent;
		this.ticketNumber = ticketNumber;
	}

	public Long getIdSocialEvent() {
		return idSocialEvent;
	}

	public void setIdSocialEvent(Long idSocialEvent) {
		this.idSocialEvent = idSocialEvent;
	}

	public Long getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(Long ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	
	
}
