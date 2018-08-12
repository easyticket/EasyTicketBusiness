package com.dise.tickets.service;

import java.util.List;

import com.dise.tickets.entity.Ticket;
import com.dise.tickets.entity.TicketPk;
import com.dise.tickets.model.TicketRequest;
import com.dise.tickets.model.TicketResponse;


public interface TicketService {
	
	public void save(Ticket ticket);

	public List<Ticket> findAll();

	public Ticket findById(TicketPk ticketPk);

	public void update(Ticket ticket);

	public void delete(TicketPk ticketPk);
	
	public List<TicketPk> createTicket(TicketRequest ticketRequest);

	public  List<TicketResponse> buildTicketResponse(List<TicketPk> ticketPk);
	

}
