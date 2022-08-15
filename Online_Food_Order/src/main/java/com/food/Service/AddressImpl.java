package com.food.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Exception.StudentException;
import com.food.model.Address;
import com.food.model.User;
import com.food.model.UserType;
import com.food.model.Customer;
import com.food.model.Login;
import com.food.model.LoginStatus;
import com.food.model.Owner;
import com.food.repository.AddressRepo;
import com.food.repository.CustomerRepo;
import com.food.repository.OwnerRepo;

@Service
public class AddressImpl implements AddressService{
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private CustomerRepo custRepo;
	
	@Autowired
	private OwnerRepo ownerRepo;
	

	@Override
	public User addAddress(Address address){
		
		User user = loginService.loginDetail();
		
		if(user.getUserType() == UserType.CUSTOMER) {
			Optional<Customer> opt = custRepo.findById(user.getUserId());
			System.out.println("login----"+opt.get());
			address.setUser(user);
			addressRepo.save(address);
			opt.get().getAddress().add(address);
			custRepo.save(opt.get());
			return user;
		}
		else {
			Optional<Owner> opt = ownerRepo.findById(user.getUserId());
			System.out.println("login----"+opt.get());
			address.setUser(user);
			addressRepo.save(address);
			opt.get().getAddress().add(address);
			ownerRepo.save(opt.get());
			return user;
		}
		
	}

}
