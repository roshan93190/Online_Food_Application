package com.food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer>{
	
}