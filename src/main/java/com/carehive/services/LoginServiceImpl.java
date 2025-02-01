package com.carehive.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carehive.entities.User;
import com.carehive.repositories.UserRepository;


@Service
public class LoginServiceImpl implements LoginService {


	@Autowired
	UserRepository userRepository;
	
	@Override
	public User login(User user) {
		if(user.getEmail()==null) {
			throw new RuntimeException("username cannot be empty ");
			}
		
		   if(user.getPassword()==null) {
			    throw new RuntimeException("password cannot be empty");
		   }
		  
		   
	   User loggedInUser =userRepository.findByEmail(user.getEmail());
	   if(loggedInUser ==null) {
		   throw new RuntimeException("user not exists!");
	   }
	   
	   if(!user.getPassword().equals(loggedInUser.getPassword())) {
		   throw new RuntimeException("please enter a valid password!");
	   }
	   
	   return loggedInUser;
	}

}
