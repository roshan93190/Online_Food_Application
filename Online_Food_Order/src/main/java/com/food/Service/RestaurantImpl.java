package com.food.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Exception.StudentException;
import com.food.Repository.ItemRepo;
import com.food.Repository.OwnerRepo;
import com.food.Repository.RestaurantRepo;
import com.food.model.Address;
import com.food.model.Item;
import com.food.model.Login;
import com.food.model.Owner;
import com.food.model.Restaurant;
import com.food.model.UserType;



@Service
public class RestaurantImpl implements RestaurantService{
	
	@Autowired
	private RestaurantRepo rest_repo;
	
	@Autowired
	private OwnerRepo ownerRepo;
	
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ItemRepo itemRepo;

	@Override
	public Restaurant addRestaurant(Restaurant restaurant, Integer ownerId) throws StudentException {
		
		Login login = loginService.loginDetail();
		
		if(login.getUserType() == UserType.OWNER) {
			//if not exists then insert new restaurant
			Optional<Owner> opt = ownerRepo.findById(ownerId);
			if(opt.isPresent()) {
				//Entered restaurant are exists or not
				List<Restaurant> list = rest_repo.findAll();
				if(list.size() > 0) {
					for(Restaurant r : list) {
						if(r.getRest_name().equals(restaurant.getRest_name())) {
							throw new StudentException("Restaurant Already added");
						}
					}
				}
				restaurant.setOwner(opt.get());
				Restaurant newRestro = rest_repo.save(restaurant);
				List<Restaurant> lr = opt.get().getRestaurants();
				lr.add(newRestro);
				ownerRepo.save(opt.get());
				return newRestro;
			}
			else {
				throw new StudentException("Please insert Currect Owner id");
			}
		}
		else {
			throw new StudentException("Please login with owner ID");
		}
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		 return rest_repo.findAll();
	}

	@Override
	public Restaurant addAddress(Address address, Integer restId) {
		Login login = loginService.loginDetail();
		
		if(login.getUserType() == UserType.OWNER) {
			Optional<Restaurant> opt = rest_repo.findById(restId);
			if(opt.isPresent()) {
				
				if(opt.get().getRest_address() == null) {
					if(opt.get().getOwner().getUserId() == login.getUserId()) {
						opt.get().setRest_address(address);
						rest_repo.save(opt.get());
						return opt.get();
					}
					else {
						throw new StudentException("Restaurant ID not valid");
					}
				}
				else {
					throw new StudentException("Address is already added...");
				}
			}
			else {
				throw new StudentException("Restaurant ID not valid");
			}
			
		}
		else {
			throw new StudentException("You are not an Authorized person");
		}
	}

	@Override
	public Restaurant AddItems(Item item, Integer restId) throws StudentException{
		System.out.println("hello");
		Optional<Restaurant> opt = rest_repo.findById(restId);
		if(opt.isPresent()) {
			 Item item2 = itemRepo.save(item);
//			 opt.get().getItem_list().add(item2);
			return rest_repo.save(opt.get());
//			return opt.get();
		}
		else {
			throw new StudentException("Invalid restaurant ID");
		}
	}



}
