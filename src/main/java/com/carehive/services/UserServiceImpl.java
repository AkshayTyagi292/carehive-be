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
		if(user==null) {
			  throw new RuntimeException("please enter valid user details");
		}
		if(user.getDate()==null||user.getDate().isAfter(LocalDate.now())) {
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

	
	
	@Override
	public User updateUser(User user, int id) {
		// TODO Auto-generated method stub
		
		User userToUpdate=userRepository.findById(id).get();
		if(userToUpdate==null) {
			  throw new RuntimeException("user does not exists");
		}
			    
	     if (user.getUserType() != null) {
	            userToUpdate.setUserType(user.getUserType());
	        }
	        if (user.getName() != null) {
	            userToUpdate.setName(user.getName());
	        }
	        if (user.getEmail() != null) {
	            userToUpdate.setEmail(user.getEmail());
	        }
	        if (user.getContact() != null) {
	            userToUpdate.setContact(user.getContact());
	        }
	        if (user.getEmergencyContact() != null) {
	            userToUpdate.setEmergencyContact(user.getEmergencyContact());
	        }
	        if (user.getGender() != null) {
	            userToUpdate.setGender(user.getGender());
	        }
	        if (user.getDate() != null) {
	            userToUpdate.setDate(user.getDate());
	        }
	        if (user.getPassword() != null ) {
	            // Encode the new password before setting it
	            userToUpdate.setPassword(user.getPassword());
	        }
	    
	        return userRepository.save(userToUpdate);
						  
	}	
	
	
	
	
	}


