package com.dise.tickets.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dise.tickets.dao.SocialEventDao;
import com.dise.tickets.entity.Category;
import com.dise.tickets.entity.SocialEvent;
import com.dise.tickets.model.SocialEventResponse;
import com.dise.tickets.service.SocialEventService;
import com.dise.tickets.util.DateSetup;

import ma.glasnost.orika.MapperFactory;

@Service
@Transactional
public class SocialEventServiceImpl implements SocialEventService{

	@Autowired
	private SocialEventDao socialEventDao;
	
	@Override
	public void save(SocialEvent socialEvent) {
		socialEventDao.save(socialEvent);
	}

	@Override
	public List<SocialEvent> findAll() {
		return socialEventDao.findAll();
	}
	@Override
	public List<SocialEvent> findByCost(int cost) {
		return socialEventDao.findByCost(cost);
	}
	@Override
	public List<SocialEvent> findByDate(Timestamp dateStart, Timestamp dateEnd) {
		return socialEventDao.findByDate(dateStart, dateEnd);
	}
	
	@Override
	public List<SocialEvent> findByDateAndCity(Timestamp dateStart, Timestamp dateEnd, Long city) {
		return socialEventDao.findByDateAndCty(dateStart, dateEnd, city);
	}
	
	@Override
	public List<SocialEventResponse> findEventByCategory(Long category) {
		List<SocialEvent> events  = socialEventDao.findByCategory(category);
		return convertEntityToModel(events);
		
	}
	
	public List<SocialEventResponse> convertEntityToModel(List<SocialEvent> eventsEntity){
		List<SocialEventResponse> events = new ArrayList<>();
		for(SocialEvent se:eventsEntity) {
			SocialEventResponse socialEventResponse =
					new SocialEventResponse(se.getId(), se.getName(), DateSetup.formatterDate(se.getDateStart()), DateSetup.formatterDate(se.getDateEnd()), se.getPriceTicket(),
							se.getAvailableTickets(), se.getDescription());
			events.add(socialEventResponse);
		}
		return events;
	}


	@Override
	public SocialEvent findById(Long id) {
		return socialEventDao.findById(id);
	}

	@Override
	public SocialEvent findByName(String name) {
		return socialEventDao.findByName(name);
	}

	@Override
	public void update(SocialEvent socialEvent) {
		socialEventDao.update(socialEvent);
	}

	@Override
	public void delete(Long id) {
		socialEventDao.delete(id);
		
	}




}
