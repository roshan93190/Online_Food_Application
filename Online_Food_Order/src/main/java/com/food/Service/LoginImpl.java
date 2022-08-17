package com.food.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Exception.StudentException;
import com.food.Repository.LoginRepo;
import com.food.model.Customer;
import com.food.model.Login;
import com.food.model.LoginStatus;
import com.food.model.Owner;
import com.food.model.UserDTO;
import com.food.model.UserType;



@Service
public class LoginImpl implements LoginService{
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private OwnerService ownerService;

	@Autowired
	private LoginRepo loginRepo;

	@Override
	public String login(UserDTO custDTO, String usertype) throws StudentException{
		if(usertype.equalsIgnoreCase("customer")) {
				
			// if any persone is logged in then it will throw exception
			List<Login> loginList = loginRepo.findAll();
			if(loginList.size()>0) {
				for(Login l : loginList) {
					if(l.getStatus() == LoginStatus.LOGGED_IN) {
						throw new StudentException("Already loggedin");
					}
				}
			}
			
			
			// if no one loggedin then we find the user details 
			
			Customer customer = customerService.findByNameAndPassword(custDTO.getUserName(), custDTO.getUserPassword());
			System.out.println("------------------------------");
			if(customer != null) {
				Login newLogin = new Login();
				newLogin.setApiKey(UUID.randomUUID().toString().replaceAll("-", "").substring(0,10));
				newLogin.setStatus(LoginStatus.LOGGED_IN);
				
				newLogin.setUserId(customer.getUserId());
				newLogin.setCartId(customer.getCart().getCartId());
				newLogin.setUserType(UserType.CUSTOMER);
				loginRepo.save(newLogin);
				return "You are successfully login";
			}
			else {
				throw new StudentException("Please insert valid username and password.");
			}
			

		}
		else if(usertype.equalsIgnoreCase("owner")) {
			// if any persone is logged in then it will throw exception
			List<Login> loginList = loginRepo.findAll();
			for(Login l : loginList) {
				if(l.getStatus() == LoginStatus.LOGGED_IN) {
					throw new StudentException("Already loggedin");
				}
			}
			
			// if no one loggedin then we find the use details 
			System.out.println("------------------------------");
			Owner owner = ownerService.findByNameAndPassword(custDTO.getUserName(), custDTO.getUserPassword());
			Login newLogin = new Login();
			newLogin.setApiKey(UUID.randomUUID().toString().replaceAll("-", "").substring(0,10));
			newLogin.setStatus(LoginStatus.LOGGED_IN);
			newLogin.setUserId(owner.getUserId());
			newLogin.setUserType(UserType.OWNER);
			loginRepo.save(newLogin);
			return "You are successfully login";
		}
		else {
			
			throw new StudentException("Login Failed");
		}
	}


	@Override
	public String logout() {
		List<Login> loginList = loginRepo.findAll();
		for(Login l : loginList) {
			
			l.setStatus(LoginStatus.LOGGED_OUT);
		}
		loginRepo.saveAll(loginList);
		return "Successfully Logout";
	}


	@Override
	public Login loginDetail() {
		List<Login> loginList = loginRepo.findAll();
		
		
		for(Login l : loginList) {
			if(l.getStatus() == LoginStatus.LOGGED_IN) {
				
				return l;
			}
		}
		throw new StudentException("You have to login first...");
	}

	

}
