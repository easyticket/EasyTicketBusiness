package com.dise.tickets.service;

import java.util.List;

import com.dise.tickets.model.City;
import com.dise.tickets.model.SocialEvent;

public interface CityService {
	
	public void save(City city);

	public List<City> findAll();
	
	public SocialEvent findById(Long id);

	public SocialEvent findByName(String name);

	public void update(City city);

	public void delete(Long id);
}
