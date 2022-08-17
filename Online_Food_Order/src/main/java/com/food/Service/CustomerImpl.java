package com.food.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Exception.StudentException;
import com.food.Repository.CustomerRepo;
import com.food.Repository.LoginRepo;
import com.food.model.Customer;
import com.food.model.FoodCart;
import com.food.model.Login;
import com.food.model.LoginStatus;
import com.food.model.UserDTO;
import com.food.model.UserType;


@Service
public class CustomerImpl implements CustomerService{
	
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private LoginRepo loginRepo;



	@Override
	public Customer addCustomer(Customer customer, UserType userType) throws StudentException {
		
		List<Login> listOfLogin = loginRepo.findAll();
		if(listOfLogin.size()>0) {
			for(Login lg: listOfLogin) {
				if(lg.getStatus() == LoginStatus.LOGGED_IN) {
					throw new StudentException("Already loggedin, first Logout and then create an account");
				}
			}
		}
		
		
		List<Customer> listCustomers = custRepo.findAll();
		if(listCustomers.size()>0) {
			for(Customer c:listCustomers) {
				if(c.getUserName().equals(customer.getUserName())) {
					throw new StudentException("User name is not available");
				}
			}
			FoodCart fc = new FoodCart();
			fc.setCustomer(customer);
			customer.setCart(fc);
			customer.setUserType(userType);
			return custRepo.save(customer);
		}
		else {
			FoodCart fc = new FoodCart();
			fc.setCustomer(customer);
			customer.setCart(fc);
			customer.setUserType(userType);
			return custRepo.save(customer);
		}
		
	}

	@Override
	public String removeCustomer(UserDTO custDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() {
		List<Customer> allCustomerList = custRepo.findAll();
		return allCustomerList;
	}

	@Override
	public Customer findByNameAndPassword(String userName, String password) {
		List<Customer> cust_list = custRepo.findAll();
//		System.out.println(cust.getFirstName()+"------------------------------");
		for(Customer cust: cust_list) {
			if(cust.getUserName().equals(userName) && cust.getUserPassword().equals(password)) {
				
				return cust;
			}
		}
		throw new StudentException("Username and password not valid");
	}

	
//	//************* Add Customer *****************************************************************
//	@Override
//	public Customer addCustomer(Customer customer){
//		return null;
//		
////		List<Login> loginList = loginRepo.findAll();
////		boolean loginFlag = false;
////		if(loginList.size()>0) {
////			for(Login l : loginList) {
////				if(l.getStatus() == LoginStatus.LOGGED_IN) {
////					loginFlag = true;
////				}
////			}
////		}
////		
////		if(!loginFlag) {
////			Optional<Customer> opt =  userRepo.findCustomerByUserName(customer.getUserName());
////			if(!opt.isPresent()) {
////				FoodCart fc = new FoodCart();
////				fc.setCustomer(customer);
////				customer.setCart(fc);
////				Customer savedCustomer = userRepo.save(customer);
////				return savedCustomer;
////			}
////			else {
////				throw new StudentException("Customer already exist with username: "+customer.getUserName());
////			}
////		}
////		else {
////			throw new StudentException("Loggout first and then craeate new Account");
////		}
//	}
	

	

}
