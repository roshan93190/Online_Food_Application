package com.food.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.model.Category;
import com.food.service.CategoryService;

@RestController
@RequestMapping("/foodPanda")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/category")
	public ResponseEntity<Category> addCategory(@RequestBody Category category){
		Category cate = categoryService.addCategory(category);
		return new ResponseEntity<Category>(cate, HttpStatus.CREATED);
	}
	
	@GetMapping("/category")
	public List<Category> addCategory(){
		
		return categoryService.getAllCategory();
	}
}
