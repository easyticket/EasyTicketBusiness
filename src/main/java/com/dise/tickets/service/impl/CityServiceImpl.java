package com.dise.tickets.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dise.tickets.dao.CityDao;
import com.dise.tickets.model.City;
import com.dise.tickets.service.CityService;

@Service
@Transactional
public class CityServiceImpl implements CityService{

	@Autowired
	private CityDao cityDao;
	
	@Override
	public void save(City city) {
		cityDao.save(city);
	}

	@Override
	public List<City> findAll() {
		return cityDao.findAll();
	}

	@Override
	public City findById(Long id) {
		return null;
	}

	@Override
	public City findByName(String name) {
		return null;
	}

	@Override
	public void update(City city) {
		
	}

	@Override
	public void delete(Long id) {
		
	}

}
