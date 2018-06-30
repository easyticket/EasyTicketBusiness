package com.dise.tickets.service;

import java.sql.Timestamp;
import java.util.List;

import com.dise.tickets.entity.SocialEvent;
import com.dise.tickets.model.SocialEventResponse;

public interface SocialEventService {
	
	public void save(SocialEvent event);

	public List<SocialEvent> findAll();
	
	public List<SocialEvent> findByCost(int cost);

	public List<SocialEvent> findByDate(Timestamp dateStart, Timestamp dateEnd);
	
	public List<SocialEvent> findByDateAndCity(Timestamp dateStart, Timestamp dateEnd,Long city);
	
	public List<SocialEventResponse> findEventByCategory(Long category);

	public SocialEvent findById(Long id);

	public SocialEvent findByName(String name);

	public void update(SocialEvent event);

	public void delete(Long id);
}
