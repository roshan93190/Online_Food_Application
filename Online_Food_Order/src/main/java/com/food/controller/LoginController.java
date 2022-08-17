package com.food.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.model.User;
import com.food.model.UserDTO;
import com.food.Service.LoginService;


@RestController
@RequestMapping("/foodPanda")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping("/login/{type}")
	public ResponseEntity<String> loginUser(@RequestBody @Valid UserDTO loginInfo, @PathVariable String type) {
		String s = loginService.login(loginInfo, type);
		return new ResponseEntity<String>(s,HttpStatus.OK);
	}
	
	
	@GetMapping("/logout")
	public String logoutUser() {
		return loginService.logout();
	}

}
