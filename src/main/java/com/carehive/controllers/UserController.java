package com.carehive.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carehive.entities.User;
import com.carehive.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
   public User register(@RequestBody User user) {	     
	   return userService.register(user);
   }
	
	@GetMapping("/userDetails/{id}")
	public User getDetails(@PathVariable int id) {
		  return userService.getDetails(id);
	}
	
	@PatchMapping("/updateUserDetails/{id}")
	public User uodateUserDetails(@RequestBody User user,@PathVariable int id) {
		   return userService.updateUser(user,id);
	}
}
