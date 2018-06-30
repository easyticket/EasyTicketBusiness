package com.dise.tickets.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.dise.tickets.dao.AbstractSession;
import com.dise.tickets.dao.CategoryDao;
import com.dise.tickets.entity.Category;

@Repository
@Transactional
public class CategoryDaoImpl extends AbstractSession implements CategoryDao{

	@Override
	public void save(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Category> findAll() {
		return getSession().createQuery("from Category").list();

	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Category findByName(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
