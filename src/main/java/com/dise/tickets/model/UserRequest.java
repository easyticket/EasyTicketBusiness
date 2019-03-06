package com.dise.tickets.model;

import javax.validation.constraints.NotNull;

public class UserRequest {
	
	@NotNull
	private String email;
	@NotNull
	private String user;
	@NotNull
	private String password;
	
	
	public UserRequest() {
		super();
	}

	public UserRequest(String email, String user, String password) {
		super();
		this.email = email;
		this.user = user;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
