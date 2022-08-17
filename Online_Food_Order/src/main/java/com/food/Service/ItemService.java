package com.food.Service;

import java.util.List;

import com.food.model.Item;

public interface ItemService {
	
	public Item addItem(Item item, Integer restroId, Integer cateId);

	public List<Item> getAllItem();
	

}
