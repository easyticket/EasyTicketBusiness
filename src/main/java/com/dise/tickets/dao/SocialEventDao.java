package com.dise.tickets.dao;

import java.util.List;


import com.dise.tickets.model.SocialEvent;

public interface SocialEventDao {
	
	public void save(SocialEvent socialEvent);

	public List<SocialEvent> findAll();

	public SocialEvent findById(Long id);

	public SocialEvent findByName(String name);

	public void update(SocialEvent socialEvent);

	public void delete(Long id);
	
}
