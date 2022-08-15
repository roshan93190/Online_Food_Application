package com.food.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.niraj.model.Owner;

@Repository
public interface OwnerRepo extends JpaRepository<Owner, Integer>{

}
