package com.carehive.controllers;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carehive.entities.User;
import com.carehive.repositories.UserRepository;
import com.carehive.security.AuthResponse;
import com.carehive.security.JwtUtil;
import com.carehive.security.LoginRequest;
import com.carehive.services.LoginService;
import com.carehive.services.UserService;


@RestController
@RequestMapping("/user")
public class LoginController {
    
	@Autowired
	LoginService loginService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;

	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtil jwtUtil;
	
//	@PostMapping("/login")
//	public User Login(@RequestBody User user) {
//		 return loginService.login(user);
//		  
//		  	}
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail());
		if (user == null) {
			return ResponseEntity.status(401).body("Invalid Credentials");
		}

		//System.out.println("Entered Password: " + request.getPassword());
		//System.out.println("Stored Hashed Password: " + user.getPassword());

		if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			return ResponseEntity.status(401).body("Invalid Credentials");
		}

		String token = jwtUtil.generateToken(user.getEmail());
		return ResponseEntity.ok(new AuthResponse(token,user));
	}

	
	
	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestBody Map<String, String> request) {
		
		return loginService.forgotPassword(request);
	}

	@PostMapping("/resetPassword")
	public String resetPassword(@RequestParam String token, @RequestBody String newPassword) {
		return loginService.resetPassword(token,newPassword);
	}
}
