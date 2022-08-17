package com.food.Service;

import com.food.model.Login;
import com.food.model.UserDTO;

public interface LoginService {

	public String login(UserDTO custDTO, String UserType);
	
	public String logout();
	
	public Login loginDetail();
}
