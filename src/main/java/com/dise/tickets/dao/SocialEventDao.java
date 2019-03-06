package com.dise.tickets.dao;

import java.time.LocalDate;
import java.util.List;

import com.dise.tickets.entity.SocialEvent;

public interface SocialEventDao {
	
	public void save(SocialEvent socialEvent);

	public List<SocialEvent> findAll();
	
	public List<SocialEvent> findByDate(LocalDate dateStart, LocalDate dateEnd);
	
	public List<SocialEvent> findByCost(int cost);
	
	public List<SocialEvent> findByDateAndCty(LocalDate dateStart, LocalDate dateEnd,Long city);

	public List<SocialEvent> findByCategory(Long category);

	public SocialEvent findById(Long id);

	public SocialEvent findByName(String name);

	public void update(SocialEvent socialEvent);

	public void delete(Long id);
	
}
