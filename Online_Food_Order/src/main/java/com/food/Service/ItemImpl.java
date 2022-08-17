package com.food.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.Exception.StudentException;
import com.food.Repository.CategoryRepo;
import com.food.Repository.ItemRepo;
import com.food.Repository.RestaurantRepo;
import com.food.model.Category;
import com.food.model.Item;
import com.food.model.Restaurant;



@Service
public class ItemImpl implements ItemService{

	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private RestaurantRepo restaurantRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public Item addItem(Item item, Integer restroId, Integer cateId) {
		System.out.println(restroId);
		Optional<Restaurant> opt = restaurantRepo.findById(restroId);
		
		if(opt.isPresent()) {
			
			Optional<Category> opt2 = categoryRepo.findById(cateId);
			if(opt2.isPresent()) {
				Item itm = itemRepo.save(item);
				Category cat = opt2.get();
				cat.getItem_list().add(itm);
				categoryRepo.save(cat);
				Restaurant rest = opt.get();
				rest.getItem_list().add(itm);
				restaurantRepo.save(rest);
				return itm;
			}
			else {
				throw new StudentException("CategoryId invalid");
			}
			
//			return item;
			
		}else {
			throw new StudentException("Invalid restraunt  Id");
		}
		
	}

	@Override
	public List<Item> getAllItem() {
		List<Item> list  = itemRepo.findAll();
		if(list.size()>0) {
			return list;
		}
		else {
			throw new StudentException("Record not found");
		}
	}

}
