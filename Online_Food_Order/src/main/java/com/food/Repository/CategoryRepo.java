package com.food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.food.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
