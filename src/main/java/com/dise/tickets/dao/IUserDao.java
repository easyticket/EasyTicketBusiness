package com.dise.tickets.dao;

import org.springframework.data.repository.CrudRepository;

import com.dise.tickets.entity.UserTicket;

public interface IUserDao extends CrudRepository<UserTicket, Long>{
	
	public UserTicket findByUsername (String username); 

}
