package com.dise.tickets.dao;

import java.sql.SQLException;

import com.dise.tickets.entity.UserTicket;

public interface UserDao {
	public void save(UserTicket userTicket) throws SQLException ;
}