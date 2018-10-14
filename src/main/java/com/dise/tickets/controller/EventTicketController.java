package com.dise.tickets.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dise.tickets.entity.Ticket;
import com.dise.tickets.entity.TicketPk;
import com.dise.tickets.model.TicketRequest;
import com.dise.tickets.model.TicketResponse;
import com.dise.tickets.service.TicketService;

@RestController
@RequestMapping("/v1")
public class EventTicketController {
	@Autowired
	TicketService ticketService;

	// GET
	@RequestMapping(value = "/ticket", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Ticket>> getTickets() {
		List<Ticket> tickets = new ArrayList<>();
		tickets = ticketService.findAll();
		if (tickets.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Ticket>>(tickets, HttpStatus.OK);

	}

	// GET
	@RequestMapping(value = "/ticket/{socialEventId}/{ticketNumber}", method = RequestMethod.GET)
	public ResponseEntity<Ticket> getTicket(@PathVariable("socialEventId") Long idSocialEvent,
			@PathVariable("ticketNumber") String ticketNumber) {
		Ticket ticket = new Ticket();
		ticket = ticketService.findById(new TicketPk(idSocialEvent, ticketNumber));
		if (ticket == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

	}

	// POST
	@RequestMapping(value = "/ticket", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> postTicket(@RequestBody Ticket ticket) {

		ticketService.save(ticket);
		return new ResponseEntity(HttpStatus.ACCEPTED);

	}

	@RequestMapping(value = "/ticket/create", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<TicketResponse> createTicket(@Valid @RequestBody TicketRequest ticketRequest) {
		List<TicketPk> ticketPk = ticketService.createTicket(ticketRequest);
		return ticketService.buildTicketResponse(ticketPk);

	}
	

}
