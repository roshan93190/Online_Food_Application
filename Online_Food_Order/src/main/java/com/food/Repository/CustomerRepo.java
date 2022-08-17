package com.food.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

//	public Optional<Customer> findByUserName(String username);
//	
//	public Optional<Customer> findByUserNameAndUserPassword(String userName, String password);
//	
//	public Customer findByUserId(int customerId);
}