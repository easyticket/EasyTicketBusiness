package com.dise.tickets.dao;

import java.util.List;
import com.dise.tickets.model.Ticket;
import com.dise.tickets.model.TicketPk;

public interface TicketDao {

	public void save(Ticket ticket);

	public List<Ticket> findAll();

	public Ticket findById(TicketPk id);

	public void update(Ticket event);

	public void delete(TicketPk id);
}