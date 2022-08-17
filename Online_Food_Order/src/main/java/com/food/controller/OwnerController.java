package com.food.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.model.Owner;
import com.food.model.UserType;
import com.food.service.OwnerService;

@RestController
@RequestMapping("/foodPanda")
public class OwnerController {
	
	@Autowired
	private OwnerService ownerService;
	
	@PostMapping("/owner")
	public Owner addOwner(@RequestBody  @Valid Owner owner) {
		return ownerService.addOwner(owner, UserType.OWNER);		
	}
	
	@GetMapping("/owner")
	public List<Owner> getAllOwner(){
		return ownerService.getAllOwners();
	}
	
}

