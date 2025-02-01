package com.carehive.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carehive.entities.User;
import com.carehive.services.LoginService;

@RestController
@RequestMapping("/user")
public class LoginController {
    
	@Autowired
	LoginService loginService;
	
	@PostMapping("/login")
	public User Login(@RequestBody User user) {
		 return loginService.login(user);
		  
		  	}
}
