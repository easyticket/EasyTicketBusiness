package com.dise.tickets.service.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dise.tickets.dao.TicketDao;
import com.dise.tickets.entity.SocialEvent;
import com.dise.tickets.entity.Ticket;
import com.dise.tickets.entity.TicketPk;
import com.dise.tickets.enums.TicketStatus;
import com.dise.tickets.model.TicketRequest;
import com.dise.tickets.model.TicketResponse;
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

	@Override
	public TicketPk createTicket(TicketRequest ticketRequest) {
			
		Ticket ticket = new Ticket();
	
		ticket.setTicketpk(createPkTicket(ticketRequest));

		SocialEvent socialEvent = new SocialEvent();
		socialEvent.setIdEvent(ticketRequest.getIdEvent());
		ticket.setSocialEvent(socialEvent);
		
		ticket.setNumberTicket(generateNumberTicket());
		ticket.setTicketStatus(TicketStatus.GENERATE);
		
		save(ticket);
		
		return ticket.getTicketpk();
		
	}
	
	private TicketPk createPkTicket(TicketRequest ticketRequest) {
		TicketPk ticketPk = new TicketPk();
		ticketPk.setIdSocialEvent(ticketRequest.getIdEvent());
		ticketPk.setIdTicket(generateHashTicket());
		return ticketPk;
	}
	
	private String generateHashTicket() {
		return UUID.randomUUID().toString();
	}
	
	private Integer generateNumberTicket() {
<<<<<<< HEAD
		return (int) (Math.random() * 1000) + 1;
=======
		Random rnd = new Random();
		return (int) (rnd.nextDouble() * 1 + 100000);
>>>>>>> d7822a3990d14c540acb555625cfb4c8efd2a820
	}
	
	// move to utils
	private String formatterDate(Timestamp timesTamp) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		return dateFormat.format(timesTamp);
	}

	@Override
	public TicketResponse buildTicketResponse(TicketPk ticketPk) {
			Ticket ticketQuery = findById(ticketPk);
		
			TicketResponse ticketResponse = new TicketResponse();
			
			ticketResponse.setAddress("");
			ticketResponse.setNameEvent(ticketQuery.getSocialEvent().getName());
			ticketResponse.setCost(ticketQuery.getSocialEvent().getPriceTicket());
			ticketResponse.setDate(formatterDate(ticketQuery.getSocialEvent().getDateStart()));
			ticketResponse.setNumber(ticketQuery.getNumberTicket().toString());
			return ticketResponse;
		
	}
	

}
