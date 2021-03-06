package com.dise.tickets.controller;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

import com.dise.tickets.entity.SocialEvent;
import com.dise.tickets.model.SocialEventResponse;
import com.dise.tickets.service.SocialEventService;
import com.dise.tickets.util.CustomErrorType;

@RestController
@RequestMapping("/v1")
public class SocEventController {

	@Autowired
	SocialEventService socialEventService;

	// GET
	@CrossOrigin(origins ="*")
	@RequestMapping(value = "/socialEvent", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<SocialEvent>> getSocialEvent() {
		List<SocialEvent> socialEvents = new ArrayList<>();
		socialEvents = socialEventService.findAll();
		if (socialEvents.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Not found events"),HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<SocialEvent>>(socialEvents, HttpStatus.OK);

	}

	@CrossOrigin(origins ="*")
	@RequestMapping(value = "/socialEvents/{category}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<SocialEventResponse> getSocialEvent(@PathVariable("category") Long category) {
		List<SocialEventResponse> socialEvents = new ArrayList<>();
		socialEvents = socialEventService.findEventByCategory(category);
		/*if (socialEvents.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Not found events"),HttpStatus.NO_CONTENT);
		}*/
		return socialEvents;

	}
	
	@CrossOrigin(origins ="*")
	@RequestMapping(value = "/socialEventById/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public SocialEventResponse getSocialEvents(@PathVariable("id") Long id) {
		SocialEventResponse socialEvents;
		socialEvents = socialEventService.findById(id);
		/*if (socialEvents.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Not found events"),HttpStatus.NO_CONTENT);
		}*/
		return socialEvents;

	}

	
	// GET
	@CrossOrigin(origins ="*")
	@RequestMapping(value = "/socialEvent/{startDate}/{endDate}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public  List<SocialEventResponse>  getSocialEventForDate(@PathVariable("startDate") String startD,
			@PathVariable("endDate") String endD) {
		List<SocialEventResponse> socialEvents = new ArrayList<>();
		LocalDate startDate = LocalDate.parse(startD);
		LocalDate endDate = LocalDate.parse(endD);

		socialEvents = socialEventService.findByDate(startDate, endDate);
		
		return socialEvents;

	}
	
	// GET
	@CrossOrigin(origins ="*")
	@RequestMapping(value = "/socialEvent/{dateStart}/{dateEnd}/{city}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<SocialEvent>> getSocialEventForDate(@PathVariable("dateStart") String dateStart,
			@PathVariable("dateEnd") String dateEnd,@PathVariable("city") Long city) {
		List<SocialEvent> socialEvents = new ArrayList<>();
//		socialEvents = socialEventService.findByDateAndCity(dateStart, dateEnd, city);
//		if (socialEvents.isEmpty()) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}

		return new ResponseEntity<List<SocialEvent>>(socialEvents, HttpStatus.OK);

	}

	// GET
//	@RequestMapping(value = "/socialEvent/{cost}", method = RequestMethod.GET, headers = "Accept=application/json")
//	public ResponseEntity<List<SocialEvent>> getSocialEventForCost(@PathVariable("cost") int cost) {
//		List<SocialEvent> socialEvents = new ArrayList<>();
//		socialEvents = socialEventService.findByCost(cost);
//		if (socialEvents.isEmpty()) {
//			return new ResponseEntity(HttpStatus.NO_CONTENT);
//		}
//
//		return new ResponseEntity<List<SocialEvent>>(socialEvents, HttpStatus.OK);
//
//	}
//	

	// POST
	
	@RequestMapping(value = "/socialEvent", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> postSocialEvent(@RequestBody SocialEvent socialEvent) {

		if (socialEvent.getName().isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		if (socialEventService.findByName(socialEvent.getName()) != null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		socialEventService.save(socialEvent);

		return new ResponseEntity(HttpStatus.ACCEPTED);

	}

}