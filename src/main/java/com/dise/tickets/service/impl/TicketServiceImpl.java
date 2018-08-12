package com.dise.tickets.service.impl;

import java.util.ArrayList;
import java.util.List;
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
import com.dise.tickets.util.DateSetup;

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

//	@Override
//	public TicketPk createTicket(TicketRequest ticketRequest) {
//			
//		Ticket ticket = new Ticket();
//	
//		ticket.setTicketpk(createPkTicket(ticketRequest));
//
//		SocialEvent socialEvent = new SocialEvent();
//		socialEvent.setId(ticketRequest.getIdEvent());
//		ticket.setSocialEvent(socialEvent);
//		ticket.setIdentificationUser(ticketRequest.getIdentification());
//		ticket.setNumber(generateNumberTicket());
//		ticket.setStatus(TicketStatus.GENERATE);
//		
//		save(ticket);
//		
//		return ticket.getTicketpk();
//		
//	}
	
	@Override
	public List<TicketPk> createTicket(TicketRequest ticketRequest) {
			
		List<TicketPk> list = new ArrayList<>();
		for (int i = 0; i <ticketRequest.getQuantity(); i++) {
			
		Ticket ticket = new Ticket();
	
		ticket.setTicketpk(createPkTicket(ticketRequest));

		SocialEvent socialEvent = new SocialEvent();
		socialEvent.setId(ticketRequest.getIdEvent());
		ticket.setSocialEvent(socialEvent);
		ticket.setIdentificationUser(ticketRequest.getIdentification());
		ticket.setNumber(generateNumberTicket());
		ticket.setStatus(TicketStatus.GENERATE);
		
		save(ticket);
		list.add( ticket.getTicketpk());
		}
		
		return list;
		
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
		return (int) (Math.random() * 1000) + 1;
	}


	@Override
	public List<TicketResponse> buildTicketResponse(List<TicketPk> ticketPk) {
		
		List<TicketResponse> list = new ArrayList<>();
		
		for (int i = 0; i < ticketPk.size(); i++) {
			
			Ticket ticketQuery = findById(ticketPk.get(i));
		
			TicketResponse ticketResponse = new TicketResponse();
			
			ticketResponse.setAddress(ticketQuery.getSocialEvent().getEnterprise().getAddress());
			ticketResponse.setNameEvent(ticketQuery.getSocialEvent().getName());
			ticketResponse.setCost(ticketQuery.getSocialEvent().getPriceTicket());
			ticketResponse.setDate(DateSetup.formatterDate(ticketQuery.getSocialEvent().getDateStart()));
			ticketResponse.setNumber(ticketQuery.getNumber().toString());
			ticketResponse.setHash(ticketQuery.getTicketpk().getIdTicket());
			
			list.add(ticketResponse);
		}
			return list;	
	}
//	@Override
//	public TicketResponse buildTicketResponse(TicketPk ticketPk) {
//			Ticket ticketQuery = findById(ticketPk);
//		
//			TicketResponse ticketResponse = new TicketResponse();
//			
//			ticketResponse.setAddress(ticketQuery.getSocialEvent().getEnterprise().getAddress());
//			ticketResponse.setNameEvent(ticketQuery.getSocialEvent().getName());
//			ticketResponse.setCost(ticketQuery.getSocialEvent().getPriceTicket());
//			ticketResponse.setDate(DateSetup.formatterDate(ticketQuery.getSocialEvent().getDateStart()));
//			ticketResponse.setNumber(ticketQuery.getNumber().toString());
//			ticketResponse.setHash(ticketQuery.getTicketpk().getIdTicket());
//			return ticketResponse;	
//	}
//	
}
