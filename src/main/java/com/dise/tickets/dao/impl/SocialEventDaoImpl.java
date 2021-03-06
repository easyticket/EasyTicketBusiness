package com.dise.tickets.dao.impl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dise.tickets.dao.AbstractSession;
import com.dise.tickets.dao.SocialEventDao;
import com.dise.tickets.entity.SocialEvent;


@Repository
@Transactional
public class SocialEventDaoImpl extends AbstractSession implements SocialEventDao {

	@Override
	public void save(SocialEvent socialEvent) {
		getSession().persist(socialEvent);

	}

	@Override
	public List<SocialEvent> findAll() {
		return getSession().createQuery("from SocialEvent WHERE dateStart > current_date").list();
	}
	



	@SuppressWarnings("unchecked")
	@Override
	public List<SocialEvent> findByDateAndCty(LocalDate dateStart, LocalDate dateEnd, Long city) {
		return getSession().createQuery("FROM SocialEvent as se inner join fetch se.enterprise as ent "
				+ "	inner join fetch ent.city as city "
				+ " WHERE city.id = :city "
				+ " AND  se.dateStart BETWEEN :dateStart AND :dateEnd ")
				.setParameter("city", city).
				setParameter("dateStart", dateStart).
				setParameter("dateEnd", dateEnd).list();
	}


	@Override
	public List<SocialEvent> findByCost(int cost) {
		return getSession().createQuery("FROM SocialEvent WHERE priceTicket = :cost ")
				.setParameter("cost", cost).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SocialEvent> findByDate(LocalDate dateStart, LocalDate dateEnd) {
		return getSession().createQuery("FROM SocialEvent WHERE dateStart BETWEEN :dateStart AND :dateEnd ")
				.setParameter("dateStart", dateStart.toString()).setParameter("dateEnd", dateEnd.toString()).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SocialEvent> findByCategory(Long category) {
		return getSession().createQuery("FROM SocialEvent as se inner join fetch se.category as cat WHERE cat.id = :category ")
				.setParameter("category", category).list();
	}
	
	@Override
	public SocialEvent findById(Long id) {
		return (SocialEvent) getSession().get(SocialEvent.class, id);
	}

	@Override
	public SocialEvent findByName(String name) {
		return (SocialEvent) getSession().createQuery("from SocialEvent where name = :name").setParameter("name", name)
				.uniqueResult();

	}

	@Override
	public void update(SocialEvent socialEvent) {
		getSession().update(socialEvent);

	}

	@Override
	public void delete(Long id) {
		SocialEvent event = findById(id);
		if (event != null) {
			getSession().delete(event);
		}

	}


}
