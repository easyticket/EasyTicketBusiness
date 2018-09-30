package com.dise.tickets.service;

import com.dise.tickets.model.UserRequest;
import com.dise.tickets.model.UserResponse;

public interface UserService {
	
	public UserResponse registryUser(UserRequest userRequest);

}