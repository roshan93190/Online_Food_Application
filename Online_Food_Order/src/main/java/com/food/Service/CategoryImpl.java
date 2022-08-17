package com.food.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Exception.StudentException;
import com.food.Repository.CategoryRepo;
import com.food.model.Category;
import com.food.model.Login;
import com.food.model.UserType;

@Service
public class CategoryImpl implements CategoryService{
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private LoginService loginService;

	@Override
	public Category addCategory(Category category) throws StudentException{
		
		Login login =  loginService.loginDetail();
		if(login.getUserType() == UserType.OWNER) {
			categoryRepo.save(category);
			return category;
		}
		else {
			throw new StudentException("Login with owner id");
		}
		
	}

	@Override
	public List<Category> getAllCategory() {
		
		
		Login login =  loginService.loginDetail();
		if(login.getUserType() == UserType.OWNER) {
			List<Category> listOfCategory =  categoryRepo.findAll();
			if(listOfCategory.size() >0) {
				return listOfCategory;
			}
			else {
				throw new StudentException("Record Not found");
			}
		}
		else {
			throw new StudentException("Login with owner id");
		}
		
	}

}
