package com.food.Service;

import java.util.List;

import com.food.model.Customer;
import com.food.model.Owner;
import com.food.model.UserDTO;
import com.food.model.UserType;

public interface OwnerService {
	
	public Owner addOwner(Owner owner, UserType userType);
	
	public String removeOwner(UserDTO userDTO);
	
	public List<Owner> getAllOwners();
	
	public Owner findByNameAndPassword(String userName, String password);
	
}
