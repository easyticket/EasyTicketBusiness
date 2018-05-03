package com.dise.tickets.dao;

import java.sql.Timestamp;
import java.util.List;

import com.dise.tickets.entity.SocialEvent;

public interface SocialEventDao {
	
	public void save(SocialEvent socialEvent);

	public List<SocialEvent> findAll();
	
	public List<SocialEvent> findByDate(Timestamp dateStart, Timestamp dateEnd);
	
	public List<SocialEvent> fintByCost(int cost);
	
	public List<SocialEvent> fintByDateAndCty(Timestamp dateStart, Timestamp dateEnd,Long city);
	
	public SocialEvent findById(Long id);

	public SocialEvent findByName(String name);

	public void update(SocialEvent socialEvent);

	public void delete(Long id);
	
}
