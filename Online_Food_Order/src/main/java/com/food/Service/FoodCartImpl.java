package com.food.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Exception.StudentException;
import com.food.Repository.FoodCartRepo;
import com.food.Repository.ItemRepo;
import com.food.model.FoodCart;
import com.food.model.Item;
import com.food.model.Login;
import com.food.model.UserType;


@Service
public class FoodCartImpl implements FoodCartService{
	
	@Autowired
	private FoodCartRepo foodCartRepo;
	
	@Autowired
	private LoginService loginService;

	@Autowired
	private ItemRepo itemRepo;
	
	

	@Override
	public FoodCart addToCart(Integer itemId, Integer itemQty, UserType userType) {
		Login login= loginService.loginDetail();
		if(userType == UserType.CUSTOMER) {
			Optional<FoodCart> opt = foodCartRepo.findById(login.getCartId());
			Optional<Item> itemOpt = itemRepo.findById(itemId);
			Item itm =itemOpt.get();
			itm.setQuantity(itemQty);
			opt.get().getItemList().add(itm);
			List<Item> itemList = opt.get().getItemList();
			
			Double totalPrice = 0.0;
			if(itemList.size()>0) {
				for(Item i : itemList) {
					totalPrice += i.getQuantity() * i.getItemPrice();
				}
			}
			
			
			
			opt.get().setCartTotal(opt.get().getCartTotal() + itemOpt.get().getItemPrice());
			return foodCartRepo.save(opt.get());
		}
		else {
			throw new StudentException("Login with customer ID");
		}
	}

	@Override
	public String removeFromCart(Integer itemId) {
		Login login= loginService.loginDetail();
		if(login.getUserType() == UserType.CUSTOMER) {
			Optional<FoodCart> opt = foodCartRepo.findById(login.getCartId());
			
			
			List<Item> listOfItems = opt.get().getItemList();
			
			if(listOfItems.size()>0) {
				int index = -1;
				for(int i=0; i<listOfItems.size(); i++) {
					if(listOfItems.get(i).getItemId() == itemId) {
						index = i;
						break;
					}
				}
				
				Item item = listOfItems.remove(index);
				opt.get().setCartTotal(opt.get().getCartTotal()-item.getItemPrice());
				foodCartRepo.save(opt.get());
				return item.getItemName()+" Removed";
			}
			else {
				throw new StudentException("Cart is empty!");
			}
			
		}
		else {
			throw new StudentException("Login with customer ID");
		}
	}

	@Override
	public FoodCart cartItems() {
		Login login= loginService.loginDetail();
		if(login.getUserType() == UserType.CUSTOMER) {
			System.out.println("hello--"+login.getCartId());
			Optional<FoodCart> opt = foodCartRepo.findById(login.getCartId());
			if(opt.isPresent()) {
				return opt.get();
			}
			else {
				throw new StudentException("Login with customer ID");
			}
			
		}
		else {
			throw new StudentException("Login with customer ID");
		}
		
		
	}

}
