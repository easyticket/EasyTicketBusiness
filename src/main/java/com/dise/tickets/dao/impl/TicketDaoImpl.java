package com.dise.tickets.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dise.tickets.model.Ticket;
import com.dise.tickets.model.TicketPk;
import com.dise.tickets.dao.AbstractSession;
import com.dise.tickets.dao.TicketDao;

@Repository
@Transactional
public class TicketDaoImpl  extends AbstractSession implements TicketDao {

	@Override
	public void save(Ticket ticket) {
		getSession().persist(ticket);
	}

	@Override
	public List<Ticket> findAll() {

		return getSession().createQuery("from Ticket").list();
	}

	@Override
	public Ticket findById(TicketPk id) {
		return (Ticket)	getSession().get(Ticket.class,id);
	}

	@Override
	public void update(Ticket ticket) {
		getSession().update(ticket);
	}

	@Override
	public void delete(TicketPk id) {
		Ticket ticket = findById(id);
		if(ticket != null) {
			getSession().delete(ticket);
		}
	}

}
