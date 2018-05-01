package com.dise.tickets.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.dise.tickets.enums.TicketStatus;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable{

	private static final long serialVersionUID = -3546357799690928829L;

	@EmbeddedId
	private TicketPk ticketpk; 

	@Column(name = "state_ticket")
	private TicketStatus ticketStatus;
	
	@Column(name = "number_ticket")
	private Integer numberTicket;

	@ManyToOne
	@JoinColumn(name = "id_event", insertable = false, updatable = false ,foreignKey = @ForeignKey(name = "FK_EVE_TIC"))
	private SocialEvent socialEvent;
	
	public Ticket() {
		super();
	}

	public Ticket(TicketPk ticketpk, TicketStatus ticketStatus) {
		super();
		this.ticketpk = ticketpk;
		this.ticketStatus = ticketStatus;
	}

	public TicketPk getTicketpk() {
		return ticketpk;
	}

	public void setTicketpk(TicketPk ticketpk) {
		this.ticketpk = ticketpk;
	}

	public TicketStatus getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TicketStatus ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public Integer getNumberTicket() {
		return numberTicket;
	}

	public void setNumberTicket(Integer numberTicket) {
		this.numberTicket = numberTicket;
	}

	public SocialEvent getSocialEvent() {
		return socialEvent;
	}

	public void setSocialEvent(SocialEvent socialEvent) {
		this.socialEvent = socialEvent;
	}

	
}
