package com.dise.tickets.model;

import java.math.BigDecimal;

public class SocialEventResponse {

	private Long id;

	private String name;

	private String dateStart;

	private String dateEnd;

	private Long priceTicket;

	private Integer availableTickets;

	private String description;
	
	private BigDecimal latitude;
	
	private BigDecimal longitude;
	
	private String address;

	public SocialEventResponse() {
		super();
	}

	public SocialEventResponse(Long id, String name, String dateStart, String dateEnd, Long priceTicket,
			Integer availableTickets, String description, BigDecimal latitude, BigDecimal longitude,String address) {
		super();
		this.id = id;
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.priceTicket = priceTicket;
		this.availableTickets = availableTickets;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;		
		this.address=address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	public String getDateStart() {
		return dateStart;
	}

	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}

	public String getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(String dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Long getPriceTicket() {
		return priceTicket;
	}

	public void setPriceTicket(Long priceTicket) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}
	
}
