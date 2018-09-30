package com.dise.tickets.dao;

import com.dise.tickets.entity.Role;

public interface RoleDao {
	
	public Role findByName(String name);

}
