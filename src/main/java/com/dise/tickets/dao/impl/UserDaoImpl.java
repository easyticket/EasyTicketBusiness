package com.dise.tickets.dao.impl;

import java.sql.SQLException;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dise.tickets.dao.AbstractSession;
import com.dise.tickets.dao.UserDao;
import com.dise.tickets.entity.UserTicket;


@Repository
@Transactional
public class UserDaoImpl extends AbstractSession implements UserDao{

	@Override
	public void save(UserTicket userTicket) throws SQLException{
		getSession().persist(userTicket);
	}
}
