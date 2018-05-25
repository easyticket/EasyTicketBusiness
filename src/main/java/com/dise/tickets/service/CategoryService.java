package com.dise.tickets.service;

import java.util.List;

import com.dise.tickets.entity.Category;

public interface CategoryService {

	public void save(Category Category);

	public List<Category> findAll();
	
	public Category findById(Long id);

	public Category findByName(String name);

	public void update(Category Category);

	public void delete(Long id);
}
