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

	@Column(name = "state")
	private TicketStatus status;
	
	@Column(name = "number_ticket")
	private Integer number;
	
	@Column(name = "id_user")
	private String identificationUser;

	@ManyToOne
	@JoinColumn(name = "id_event", insertable = false, updatable = false ,foreignKey = @ForeignKey(name = "FK_EVE_TIC"))
	private SocialEvent socialEvent;
	
	public Ticket() {
		super();
	}

	

	public Ticket(TicketStatus status, Integer number) {
		super();
		this.status = status;
		this.number = number;
	}



	public TicketStatus getStatus() {
		return status;
	}


	public void setStatus(TicketStatus status) {
		this.status = status;
	}


	public Integer getNumber() {
		return number;
	}


	public void setNumber(Integer number) {
		this.number = number;
	}


	public TicketPk getTicketpk() {
		return ticketpk;
	}

	public void setTicketpk(TicketPk ticketpk) {
		this.ticketpk = ticketpk;
	}


	public SocialEvent getSocialEvent() {
		return socialEvent;
	}

	public void setSocialEvent(SocialEvent socialEvent) {
		this.socialEvent = socialEvent;
	}

	public String getIdentificationUser() {
		return identificationUser;
	}

	public void setIdentificationUser(String identificationUser) {
		this.identificationUser = identificationUser;
	}
	
}
