package com.dise.tickets.service;

import java.util.List;

import com.dise.tickets.model.SocialEvent;

public interface SocialEventService {
	
	public void save(SocialEvent event);

	public List<SocialEvent> findAll();

	public SocialEvent findById(Long id);

	public SocialEvent findByName(String name);

	public void update(SocialEvent event);

	public void delete(Long id);
}
