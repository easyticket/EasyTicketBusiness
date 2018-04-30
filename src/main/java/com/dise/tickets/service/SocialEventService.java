package com.dise.tickets.service;

import java.sql.Timestamp;
import java.util.List;

import com.dise.tickets.entity.SocialEvent;

public interface SocialEventService {
	
	public void save(SocialEvent event);

	public List<SocialEvent> findAll();
	
	public List<SocialEvent> findByCost(int cost);

	public List<SocialEvent> findByDate(Timestamp dateStart, Timestamp dateEnd);
	
	public SocialEvent findById(Long id);

	public SocialEvent findByName(String name);

	public void update(SocialEvent event);

	public void delete(Long id);
}
