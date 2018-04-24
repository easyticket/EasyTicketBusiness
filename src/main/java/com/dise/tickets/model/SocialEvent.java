package com.dise.tickets.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "social_event")
public class SocialEvent implements Serializable {

	@Id
	@Column(name = "id_social_event")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvent;

	@Column(name = "name_social_event")
	private String name;

	@Column(name = "date_start_social_event")
	private Timestamp dateStart;

	@Column(name = "date_end_social_event")
	private Timestamp dateEnd;

	@Column(name = "price_ticket_social_event")
	private Integer priceTicket;

	@Column(name = "available_social_event")
	private Integer availableTickets;

	@Column(name = "description_social_event")
	private String description;

	public SocialEvent() {
		super();
	}

	public SocialEvent(String name, Timestamp dateStart, Timestamp dateEnd, Integer priceTicket, Integer availableTickets,
			String description) {
		super();
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.priceTicket = priceTicket;
		this.availableTickets = availableTickets;
		this.description = description;
	}

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getDateStart() {
		return dateStart;
	}

	public void setDateStart(Timestamp dateStart) {
		this.dateStart = dateStart;
	}

	public Timestamp getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Timestamp dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Integer getPriceTicket() {
		return priceTicket;
	}

	public void setPriceTicket(Integer priceTicket) {
		this.priceTicket = priceTicket;
	}

	public Integer getAvailableTickets() {
		return availableTickets;
	}

	public void setAvailableTickets(Integer availableTickets) {
		this.availableTickets = availableTickets;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
