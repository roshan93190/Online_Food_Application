package com.food.Service;

import java.util.List;
import java.util.Optional;

import com.food.model.Customer;
import com.food.model.UserDTO;
import com.food.model.UserType;

public interface CustomerService{
	
	public Customer addCustomer(Customer customer, UserType userType);
	
	public String removeCustomer(UserDTO custDTO);
	
	public List<Customer> getAllCustomer();
	
//	public Customer updateCustomer(UserDTO custDTO, Integer customerId);
//	
	public Customer findByNameAndPassword(String userName, String password);
//	
//	public Customer persistCustomer(Integer customerID, Login login);
//	
//	public Customer getCustomerById(Integer customerId);
//	
//	public Customer addCustomerOrder(Integer customerId, OrderDetails orderDetails);
	
}
