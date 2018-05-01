package com.dise.tickets.entity;

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
public class Ticket {

	@EmbeddedId
	private TicketPk ticketpk; 

	@Column(name = "ticket_status")
	private TicketStatus ticketStatus;

	@ManyToOne
	@JoinColumn(name = "id_social_event", insertable = false, updatable = false ,foreignKey = @ForeignKey(name = "FK_EVE_TIC"))
	private SocialEvent socialEvent;
	
	public Ticket() {
		super();
	}

	public Ticket(TicketPk ticketpk, TicketStatus ticketStatus, SocialEvent socialEvent) {
		super();
		this.ticketpk = ticketpk;
		this.ticketStatus = ticketStatus;
		this.socialEvent = socialEvent;
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

	public SocialEvent getSocialEvent() {
		return socialEvent;
	}

	public void setSocialEvent(SocialEvent socialEvent) {
		this.socialEvent = socialEvent;
	}

	

}
