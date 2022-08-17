package com.food.Service;

import java.util.List;

import com.food.model.Category;


public interface CategoryService {
	public Category addCategory(Category category);
	
	public List<Category> getAllCategory();
}
