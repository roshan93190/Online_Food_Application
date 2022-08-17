package com.food.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Login;


@Repository
public interface LoginRepo extends JpaRepository<Login, Integer>{
//	public Optional<Login> findByLoginId(Integer loginId);
//	
//	public Optional<Login> findByApiKey(String apiKey);
}
