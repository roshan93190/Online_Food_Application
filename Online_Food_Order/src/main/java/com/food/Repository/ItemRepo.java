package com.food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer>{
	
}
