package com.carehive.services;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carehive.entities.User;
import com.carehive.repositories.UserRepository;


@Service
public class LoginServiceImpl implements LoginService {


	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
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

	@Override
	public String resetPassword(String token, String newPassword) {
		newPassword = newPassword.replaceAll("^\"|\"$", "").trim();
		User user = userService.findByResetToken(token);

		if (user == null || user.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
			throw new RuntimeException("Invalid or expired token");
		}

		User existingUser = userRepository.findById(user.getId())
				.orElseThrow(() -> new RuntimeException("User not found!"));

		existingUser.setPassword(passwordEncoder.encode(newPassword));
		existingUser.setResetToken(null);
		existingUser.setResetTokenExpiry(null);

		userRepository.save(existingUser);

		return "Password successfully reset";
	}

	@Override
	public String forgotPassword(Map<String, String> request) {
		// TODO Auto-generated method stub
		String email = request.get("email");
		System.out.println("Extracted email: " + email);

		User user = userService.findByEmail(email);

		if (user == null) {
			System.out.println("User not found for email: " + email);
			throw new RuntimeException("User not found");
		}

		System.out.println("User found: " + user);

		String token = UUID.randomUUID().toString();
		user.setResetToken(token);
		user.setResetTokenExpiry(LocalDateTime.now().plusHours(1));

		userService.register(user);

		mailService.sendPasswordResetEmail(user.getEmail(), token);

		return "Password reset link sent to your email";
	}

}
