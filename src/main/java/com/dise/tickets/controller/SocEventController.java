package com.dise.tickets.controller;

import java.sql.Timestamp;
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
import com.dise.tickets.enums.ExceptionsController;
import com.dise.tickets.enums.ExceptionsModules;
import com.dise.tickets.enums.ExceptionsOperations;
import com.dise.tickets.enums.ExceptionsSpecificError;
import com.dise.tickets.model.SocialEventResponse;
import com.dise.tickets.service.SocialEventService;
import com.dise.tickets.util.CreateMessageError;
import com.dise.tickets.util.CustomErrorType;
import com.dise.tickets.util.ServiceExceptions;

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
	@RequestMapping(value = "/socialEvent/{category}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<SocialEventResponse> getSocialEvent(@PathVariable("category") Long category) throws ServiceExceptions {
		List<SocialEventResponse> socialEvents = new ArrayList<>();
		socialEvents = socialEventService.findEventByCategory(category);
		if (socialEvents.isEmpty()) {
			CreateMessageError cr = new CreateMessageError(ExceptionsModules.BUSUNESS, ExceptionsController.SOCIALEVENT, ExceptionsOperations.GET, ExceptionsSpecificError.ISEMPTY);
			throw new ServiceExceptions(cr.fullMessageError());
		}
		return socialEvents;	

	}

	
	// GET
	@RequestMapping(value = "/socialEvent/{dateStart}/{dateEnd}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<SocialEvent>> getSocialEventForDate(@PathVariable("dateStart") Timestamp dateStart,
			@PathVariable("dateEnd") Timestamp dateEnd) {
		List<SocialEvent> socialEvents = new ArrayList<>();
		socialEvents = socialEventService.findByDate(dateStart, dateEnd);
		if (socialEvents.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<SocialEvent>>(socialEvents, HttpStatus.OK);

	}
	
	// GET
	@RequestMapping(value = "/socialEvent/{dateStart}/{dateEnd}/{city}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<SocialEvent>> getSocialEventForDate(@PathVariable("dateStart") Timestamp dateStart,
			@PathVariable("dateEnd") Timestamp dateEnd,@PathVariable("city") Long city) {
		List<SocialEvent> socialEvents = new ArrayList<>();
		socialEvents = socialEventService.findByDateAndCity(dateStart, dateEnd, city);
		if (socialEvents.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}

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