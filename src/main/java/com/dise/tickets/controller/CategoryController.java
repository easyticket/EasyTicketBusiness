package com.dise.tickets.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dise.tickets.entity.Category;
import com.dise.tickets.service.CategoryService;
import com.dise.tickets.util.CustomErrorType;

@RestController
@RequestMapping("/v1")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Category>> getSocialEvent() {
		List<Category> categories = new ArrayList<>();
		categories = categoryService.findAll();
		if (categories.isEmpty()) {
			return new ResponseEntity(new CustomErrorType("Not found events"),HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);

	}
	
}
