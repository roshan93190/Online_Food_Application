package com.food.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Exception.StudentException;
import com.food.model.Customer;
import com.food.model.FoodCart;
import com.food.model.Login;
import com.food.model.LoginStatus;
import com.food.model.Owner;
import com.food.model.UserDTO;
import com.food.model.UserType;
import com.food.repository.LoginRepo;
import com.food.repository.OwnerRepo;

@Service
public class OwnerImpl implements OwnerService {

	@Autowired
	private OwnerRepo ownerRepo;

	@Autowired
	private LoginRepo loginRepo;

	@Override
	public Owner addOwner(Owner owner, UserType userType) throws StudentException {

		List<Login> listOfLogin = loginRepo.findAll();
		if (listOfLogin.size() > 0) {
			for (Login lg : listOfLogin) {
				if (lg.getStatus() == LoginStatus.LOGGED_IN) {
					throw new StudentException("Already loggedin, first Logout and then create an account");
				}
			}
		}

		List<Owner> listOfOwner = ownerRepo.findAll();
		if (listOfOwner.size() > 0) {
			for (Owner o : listOfOwner) {
				if (o.getUserName().equals(owner.getUserName())) {
					throw new StudentException("Owner already exist");

				}
			}
			owner.setUserType(userType);
			return ownerRepo.save(owner);
		} else {
			owner.setUserType(userType);
			return ownerRepo.save(owner);
		}
	}

	@Override
	public String removeOwner(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Owner> getAllOwners() {
		List<Owner> ownerList = ownerRepo.findAll();
		return ownerList;
	}

	@Override
	public Owner findByNameAndPassword(String userName, String password) {
		List<Owner> owner_list = ownerRepo.findAll();
		for (Owner owner : owner_list) {
			if (owner.getUserName().equals(userName) && owner.getUserPassword().equals(password)) {
				return owner;
			}
		}
		throw new StudentException("Username and password not valid");
	}

}
