package com.dise.tickets.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dise.tickets.model.Ticket;
import com.dise.tickets.service.TicketService;

@RestController
@RequestMapping("/v1")
public class TicketController {

	@Autowired
	TicketService ticketService;
	
	//GET
	@RequestMapping(value="/ticket", method = RequestMethod.GET, headers= "Accept=application/json")
	public ResponseEntity<List<Ticket>> getTicket(){
		List<Ticket> tickets = new ArrayList<>();
		tickets = ticketService.findAll();
		if(tickets.isEmpty()) {
			return new 	ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Ticket>>(tickets,HttpStatus.OK);
		
	}
	
	
}
