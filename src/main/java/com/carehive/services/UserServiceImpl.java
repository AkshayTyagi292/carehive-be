package com.carehive.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carehive.entities.User;
import com.carehive.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public User register(User user) {
		if(user==null||user.getDate().isAfter(LocalDate.now())) {
			  throw new RuntimeException("please enter a valid date");
		}
		  if (user.getDate().plusYears(18).isAfter(LocalDate.now())) {
		        throw new RuntimeException("User must be at least 18 years old.");
		    }
		User savedUser=userRepository.save(user); 
		 return userRepository.findById(savedUser.getId())
	                .orElseThrow(() -> new RuntimeException("User not found after saving."));
	    }

	@Override
	public User getDetails(int id) {
		// TODO Auto-generated method stub		
		 return userRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("User not exists"));
	}	
	}


