package com.dise.tickets.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dise.tickets.dao.AbstractSession;
import com.dise.tickets.dao.RoleDao;
import com.dise.tickets.entity.Role;

@Repository
@Transactional
public class RoleDaoImpl extends AbstractSession implements RoleDao{

	@Override
	public Role findByName(String name) {
		return (Role) getSession().createQuery("from Role where authority = :name").setParameter("name", name)
				.uniqueResult();
		
	}

}
