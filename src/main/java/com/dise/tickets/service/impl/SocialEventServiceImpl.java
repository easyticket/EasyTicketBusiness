package com.dise.tickets.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dise.tickets.dao.SocialEventDao;
import com.dise.tickets.entity.SocialEvent;
import com.dise.tickets.model.SocialEventResponse;
import com.dise.tickets.service.SocialEventService;


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
	public List<SocialEventResponse> findByDate(LocalDate dateStart, LocalDate dateEnd) {
		List<SocialEvent> events  =  socialEventDao.findByDate(dateStart, dateEnd);
		return convertEntityToModel(events);
	}
	
	@Override
	public List<SocialEvent> findByDateAndCity(LocalDate dateStart, LocalDate dateEnd, Long city) {
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
					new SocialEventResponse(se.getId(), se.getName(), se.getDateStart().toString(), se.getDateEnd().toString(), se.getPriceTicket(),
							se.getAvailableTickets(), se.getDescription(),  new BigDecimal(se.getLatitude().trim()),  new BigDecimal(se.getLongitude().trim()),se.getAddress());
			events.add(socialEventResponse);
		}
		return events;
	}


	@Override
	public SocialEventResponse findById(Long id) {
		
		return convertEntityToModel(socialEventDao.findById(id));
	}
	
	public SocialEventResponse convertEntityToModel(SocialEvent eventEntity){
		SocialEventResponse socialEventResponse =
				new SocialEventResponse(eventEntity.getId(), eventEntity.getName(), eventEntity.getDateStart().toString(), eventEntity.getDateEnd().toString(), eventEntity.getPriceTicket(),
						eventEntity.getAvailableTickets(), eventEntity.getDescription(),   new BigDecimal(eventEntity.getLatitude().trim()),   new BigDecimal(eventEntity.getLongitude().trim()), eventEntity.getAddress());
	return socialEventResponse;
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
