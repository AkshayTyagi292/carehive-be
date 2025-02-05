package com.carehive.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carehive.entities.User;
import com.carehive.entities.UserType;
import com.carehive.entities.UserUpdateRequest;
import com.carehive.entities.UsersServices;
import com.carehive.repositories.UserRepository;
import com.carehive.repositories.UserServicesRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserServicesService userServicesService;
	
	@Autowired
	UserServicesRepository userServicesRepository;

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
	public UserUpdateRequest getDetails(int id) {
	
		 User user = userRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("User does not exist"));

		    // Fetch list of serviceIds from user_services table
		    List<Integer> serviceIds = userServicesRepository.findByUserId(id)
		            .stream()
		            .map(UsersServices::getServiceId)
		            .collect(Collectors.toList());

		    // Construct response DTO
		    UserUpdateRequest response = new UserUpdateRequest();
		    response.setUserType(user.getUserType());
		    response.setName(user.getName());
		    response.setEmail(user.getEmail());
		    response.setContact(user.getContact());
		    response.setEmergencyContact(user.getEmergencyContact());
		    response.setGender(user.getGender());
		    response.setDate(user.getDate());
		    response.setPassword(user.getPassword());
		    response.setServiceIds(serviceIds); // Add service IDs

		    return response;
		
		
	}

	
	
//	@Override
//	public User updateUser(User user, int id) {
//		// TODO Auto-generated method stub
//		
//		User userToUpdate=userRepository.findById(id).get();
//		if(userToUpdate==null) {
//			  throw new RuntimeException("user does not exists");
//		}
//			    
//	     if (user.getUserType() != null) {
//	            userToUpdate.setUserType(user.getUserType());
//	        }
//	        if (user.getName() != null) {
//	            userToUpdate.setName(user.getName());
//	        }
//	        if (user.getEmail() != null) {
//	            userToUpdate.setEmail(user.getEmail());
//	        }
//	        if (user.getContact() != null) {
//	            userToUpdate.setContact(user.getContact());
//	        }
//	        if (user.getEmergencyContact() != null) {
//	            userToUpdate.setEmergencyContact(user.getEmergencyContact());
//	        }
//	        if (user.getGender() != null) {
//	            userToUpdate.setGender(user.getGender());
//	        }
//	        if (user.getDate() != null) {
//	            userToUpdate.setDate(user.getDate());
//	        }
//	        if (user.getPassword() != null ) {
//	            // Encode the new password before setting it
//	            userToUpdate.setPassword(user.getPassword());
//	        }
//	        
//	        
//	        
//	    
//	        return userRepository.save(userToUpdate);
//						  
//	}	
	
	@Override
	@Transactional
	public User updateUser(User user, int id, List<Integer> serviceIds) {
	    User userToUpdate = userRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("User does not exist"));

	    if (user.getUserType() != null) userToUpdate.setUserType(user.getUserType());
	    if (user.getName() != null) userToUpdate.setName(user.getName());
	    if (user.getEmail() != null) userToUpdate.setEmail(user.getEmail());
	    if (user.getContact() != null) userToUpdate.setContact(user.getContact());
	    if (user.getEmergencyContact() != null) userToUpdate.setEmergencyContact(user.getEmergencyContact());
	    if (user.getGender() != null) userToUpdate.setGender(user.getGender());
	    if (user.getDate() != null) userToUpdate.setDate(user.getDate());
	    if (user.getPassword() != null) userToUpdate.setPassword(user.getPassword());

	    // Save updated user details
	    userRepository.save(userToUpdate);

	    // Update user services
	    userServicesService.updateUserServices(id, serviceIds);

	    return userToUpdate;
	}
	
	@Override
	public List<User> getAllCaretakers() {
		// TODO Auto-generated method stub
		return userRepository.findByUserType(UserType.Caretaker);
	}

	
	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email.trim());
	}



	@Override
	public User findByResetToken(String token) {
		// TODO Auto-generated method stub
		return userRepository.findByResetToken(token);
	}





	
	
	}


