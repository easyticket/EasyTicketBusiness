package com.dise.tickets.dao.impl;

import java.sql.Timestamp;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.dise.tickets.dao.AbstractSession;
import com.dise.tickets.dao.SocialEventDao;
import com.dise.tickets.model.SocialEvent;


@Repository
@Transactional
public class SocialEventDaoImpl extends AbstractSession implements SocialEventDao {

	@Override
	public void save(SocialEvent socialEvent) {
		getSession().persist(socialEvent);

	}

	@Override
	public List<SocialEvent> findAll() {
		return getSession().createQuery("from SocialEvent").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<SocialEvent> fintByDateAndCty(Timestamp dateStart, Timestamp dateEnd, Long city) {
		return getSession().createQuery("FROM SocialEvent as se inner join fetch se.enterprise as ent "
				+ "	inner join fetch ent.city as city "
				+ " WHERE city.idCity = :city "
				+ " AND  se.dateStart BETWEEN :dateStart AND :dateEnd ")
				.setParameter("city", city).
				setParameter("dateStart", dateStart).
				setParameter("dateEnd", dateEnd).list();
	}


	@Override
	public List<SocialEvent> fintByCost(int cost) {
		return getSession().createQuery("FROM SocialEvent WHERE priceTicket = :cost ")
				.setParameter("cost", cost).list();
	}
	
	@Override
	public List<SocialEvent> findByDate(Timestamp dateStart, Timestamp dateEnd) {
		return getSession().createQuery("FROM SocialEvent WHERE dateStart BETWEEN :dateStart AND :dateEnd ")
				.setParameter("dateStart", dateStart).setParameter("dateEnd", dateEnd).list();
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
