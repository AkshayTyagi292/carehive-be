package com.carehive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carehive.entities.User;
import com.carehive.entities.UserUpdateRequest;
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
	public UserUpdateRequest getDetails(@PathVariable int id) {
		  return userService.getDetails(id);
	}
	
	
	
//	@PatchMapping("/updateUserDetails/{id}")
//	public User uodateUserDetails(@RequestBody User user,@PathVariable int id) {
//		   return userService.updateUser(user,id);
//	}
	
	
	@PatchMapping("/updateUserDetails/{id}")
	public User uodateUserDetails(@RequestBody UserUpdateRequest request,
	        @PathVariable int id){
	        	 User user = new User();
	        	    user.setUserType(request.getUserType());
	        	    user.setName(request.getName());
	        	    user.setEmail(request.getEmail());
	        	    user.setContact(request.getContact());
	        	    user.setEmergencyContact(request.getEmergencyContact());
	        	    user.setGender(request.getGender());
	        	    user.setDate(request.getDate());
	        	    user.setPassword(request.getPassword());

	        	    // Update user and services
	        	    User updatedUser = userService.updateUser(user, id, request.getServiceIds());

	        	   
		   return updatedUser;
	}
	
	@GetMapping("/caretakers")
	public List<User> getAllCaretakers() {
		return userService.getAllCaretakers();
	}
	
	
	
}
