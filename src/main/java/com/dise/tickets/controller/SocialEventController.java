	package com.dise.tickets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;import org.springframework.web.util.UriComponentsBuilder;

import com.dise.tickets.model.SocialEvent;
import com.dise.tickets.service.SocialEventService;

@RestController
@RequestMapping("/v1")
public class SocialEventController {
	
	@Autowired
	SocialEventService socialEventService;
		
	//GET
	@RequestMapping(value="/shows", method = RequestMethod.GET, headers= "Accept=application/json")
	public ResponseEntity<List<SocialEvent>> getShows(){
		List<SocialEvent> socialEvents = new ArrayList<>();
		socialEvents = socialEventService.findAll();
		if(socialEvents.isEmpty()) {
			return new 	ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<SocialEvent>>(socialEvents,HttpStatus.OK);
		
	}
	
	//POST
	@RequestMapping(value="/shows", method = RequestMethod.POST, headers="Accept=application/json")
	public ResponseEntity <?> postShows(@RequestBody SocialEvent socialEvent){	

		if(socialEvent.getName().isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		if (!socialEventService.findByName(socialEvent.getName()).equals(null)) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		
		socialEventService.save(socialEvent);
		SocialEvent socialE = socialEventService.findByName(socialEvent.getName());
		HttpHeaders headers = new HttpHeaders();
		
		
		return new ResponseEntity<String>(headers,HttpStatus.CREATED);

	}
	
	
}
