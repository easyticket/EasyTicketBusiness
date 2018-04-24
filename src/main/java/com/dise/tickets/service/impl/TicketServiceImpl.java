package com.dise.tickets.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dise.tickets.dao.TicketDao;
import com.dise.tickets.model.Ticket;
import com.dise.tickets.model.TicketPk;
import com.dise.tickets.service.TicketService;

@Service
@Transactional
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketDao ticketDao;
	
	@Override
	public void save(Ticket ticket) {
		ticketDao.save(ticket);
	}

	@Override
	public List<Ticket> findAll() {
		return ticketDao.findAll();
	}

	@Override
	public Ticket findById(TicketPk ticketPk) {
		return ticketDao.findById(ticketPk);
	}

	@Override
	public void update(Ticket ticket) {
		ticketDao.update(ticket);
	}

	@Override
	public void delete(TicketPk ticketPk) {
		ticketDao.delete(ticketPk);		
	}

}
