package com.dise.tickets.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "social_event")
public class SocialEvent implements Serializable {

	private static final long serialVersionUID = 84444129815305507L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "date_start")
	private String dateStart;

	@Column(name = "date_end")
	private String dateEnd;

	@Column(name = "price_ticket")
	private Long priceTicket;

	@Column(name = "available_tickets")
	private Integer availableTickets;

	@Column(name = "description")
	private String description;
	
	@Column(name = "latitude")
	private String latitude;

	@Column(name = "longitude")
	private String longitude;
	
	@Column(name = "address")
	private String address;
	
	@ManyToOne
	@JoinColumn(name = "id_enterprise", insertable = false, updatable = false ,foreignKey = @ForeignKey(name = "fk_soe_ent"))
	private Enterprise enterprise;

	@ManyToOne
	@JoinColumn(name = "id_category", insertable = false, updatable = false ,foreignKey = @ForeignKey(name = "fk_soe_cat"))
	private Category category;
	
	@OneToMany(mappedBy = "socialEvent")
    private List<Ticket> tickets;

	public SocialEvent() {
		super();
	}


	public SocialEvent(String name, String dateStart, String dateEnd, Long priceTicket, Integer availableTickets,
			String description,String latitude,String longitude, String address) {
		super();
		this.name = name;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.priceTicket = priceTicket;
		this.availableTickets = availableTickets;
		this.description = description;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;

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

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	

	
	
}
