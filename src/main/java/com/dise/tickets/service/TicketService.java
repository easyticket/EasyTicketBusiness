package com.dise.tickets.service;

import java.util.List;

import com.dise.tickets.entity.Ticket;
import com.dise.tickets.entity.TicketPk;


public interface TicketService {
	
	public void save(Ticket ticket);

	public List<Ticket> findAll();

	public Ticket findById(TicketPk ticketPk);

	public void update(Ticket ticket);

	public void delete(TicketPk ticketPk);
	
}
