package com.dise.tickets.model;

public class TicketResponse {
	
	private String nameEvent;
	private String date;
	private String address;
	private String number;
	private Long cost;
	private String hash;
	
	public TicketResponse() {
		super();
	}
	public String getNameEvent() {
		return nameEvent;
	}
	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Long getCost() {
		return cost;
	}
	public void setCost(Long cost) {
		this.cost = cost;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
}
