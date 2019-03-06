package com.dise.tickets.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dise.tickets.model.UserRequest;
import com.dise.tickets.model.UserResponse;
import com.dise.tickets.service.UserService;

@RestController
@RequestMapping("/v1")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/user/registry", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public UserResponse registerUser(@Valid @RequestBody UserRequest userRequest) {
		return userService.registryUser(userRequest);

	}

}
