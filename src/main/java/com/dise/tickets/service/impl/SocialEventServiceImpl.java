package com.dise.tickets.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dise.tickets.dao.SocialEventDao;
import com.dise.tickets.model.SocialEvent;
import com.dise.tickets.service.SocialEventService;

@Service
@Transactional
public class SocialEventServiceImpl implements SocialEventService{

	@Autowired
	private SocialEventDao socialEventDao;
	
	@Override
	public void save(SocialEvent socialEvent) {
		socialEventDao.save(socialEvent);
	}

	@Override
	public List<SocialEvent> findAll() {
		return socialEventDao.findAll();
	}
	
	@Override
	public List<SocialEvent> findByDate(Timestamp dateStart, Timestamp dateEnd) {
		return socialEventDao.findByDate(dateStart, dateEnd);
	}

	@Override
	public SocialEvent findById(Long id) {
		return socialEventDao.findById(id);
	}

	@Override
	public SocialEvent findByName(String name) {
		return socialEventDao.findByName(name);
	}

	@Override
	public void update(SocialEvent socialEvent) {
		socialEventDao.update(socialEvent);
	}

	@Override
	public void delete(Long id) {
		socialEventDao.delete(id);
		
	}

}
