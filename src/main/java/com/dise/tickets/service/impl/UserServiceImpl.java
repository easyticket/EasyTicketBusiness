package com.dise.tickets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dise.tickets.dao.RoleDao;
import com.dise.tickets.dao.UserDao;
import com.dise.tickets.entity.Role;
import com.dise.tickets.entity.UserTicket;
import com.dise.tickets.model.UserRequest;
import com.dise.tickets.model.UserResponse;
import com.dise.tickets.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	private final String nameRole = "ROLE_ADMIN";
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserResponse registryUser(UserRequest userRequest) {
		
		try {
			UserTicket userTicket = new  UserTicket();
			userTicket.setEmail(userRequest.getEmail());
			userTicket.setRole(findRole());
			userTicket.setUsername(userRequest.getUser());
			userTicket.setPass(passwordEncoder.encode(userRequest.getPassword()));
			userTicket.setEnabled(true);
			userDao.save(userTicket);
		
			UserResponse userResponse = new UserResponse();
			userResponse.setSuccess(true);
			userResponse.setDescription("Success");
			return userResponse;	
		} catch (Exception e) {
			UserResponse userResponse = new UserResponse();
			userResponse.setSuccess(false);
			userResponse.setDescription(e.getMessage());
			return userResponse;	 
		}
		
	}
	
	
	private Role findRole() {
		Role role = roleDao.findByName(nameRole);
		return role;
	}
	

}
