package com.dise.tickets.dao;

import java.util.List;

import com.dise.tickets.model.City;

public interface CityDao {
	
	public void save(City city);

	public List<City> findAll();
		
	public City findById(Long id);

	public City findByName(String name);

	public void update(City city);

	public void delete(Long id);
}
