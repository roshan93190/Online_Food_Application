package com.food.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.food.Exception.StudentException;
import com.food.model.Address;
import com.food.model.User;
import com.food.model.UserType;
import com.food.model.Customer;
import com.food.model.Login;
import com.food.model.LoginStatus;
import com.food.model.Owner;
import com.food.Repository.AddressRepo;
import com.food.Repository.CustomerRepo;
import com.food.Repository.OwnerRepo;

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
		
		Login login = loginService.loginDetail();
		
		if(login.getUserType() == UserType.CUSTOMER) {
			Optional<Customer> opt = custRepo.findById(login.getUserId());
			address.setUser(opt.get());
			addressRepo.save(address);
			opt.get().getAddress().add(address);
			custRepo.save(opt.get());
			return opt.get();
		}
		else {
			Optional<Owner> opt = ownerRepo.findById(login.getUserId());
			address.setUser(opt.get());
			addressRepo.save(address);
			opt.get().getAddress().add(address);
			ownerRepo.save(opt.get());
			return opt.get();
		}
		
	}

}
