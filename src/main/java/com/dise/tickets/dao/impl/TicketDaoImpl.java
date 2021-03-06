package com.dise.tickets.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dise.tickets.dao.AbstractSession;
import com.dise.tickets.dao.TicketDao;
import com.dise.tickets.entity.Ticket;
import com.dise.tickets.entity.TicketPk;

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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> findByUser(String id) {
		return getSession().createQuery("FROM Ticket WHERE identificationUser = :idUser ")
				.setParameter("idUser", id).list();
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
