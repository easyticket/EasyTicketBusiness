package com.dise.tickets.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dise.tickets.dao.AbstractSession;
import com.dise.tickets.dao.CityDao;
import com.dise.tickets.entity.City;

@Repository
@Transactional
public class CityDaoImpl extends AbstractSession implements CityDao{

	@Override
	public void save(City city) {
		getSession().persist(city);
	}

	@Override
	public List<City> findAll() {
		return getSession().createQuery("from City").list();
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
