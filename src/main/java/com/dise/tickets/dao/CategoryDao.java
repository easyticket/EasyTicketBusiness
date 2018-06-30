package com.dise.tickets.dao;

import java.util.List;

import com.dise.tickets.entity.Category;

public interface CategoryDao {
	
	public void save(Category category);

	public List<Category> findAll();
		
	public Category findById(Long id);

	public Category findByName(Category category);

	public void update(Category category);

	public void delete(Long id);
}
