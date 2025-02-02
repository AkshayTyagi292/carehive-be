package com.carehive.controllers;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carehive.entities.User;
import com.carehive.services.LoginService;
import com.carehive.services.MailServices;
import com.carehive.services.UserService;

@RestController
@RequestMapping("/user")
public class LoginController {

	@Autowired
	LoginService loginService;

	@Autowired
	MailServices mailService;

	@Autowired
	UserService userService;

	@PostMapping("/login")
	public User Login(@RequestBody User user) {
		return loginService.login(user);

	}

	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestBody Map<String, String> request) {
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

		userService.save(user);

		mailService.sendPasswordResetEmail(user.getEmail(), token);

		return "Password reset link sent to your email";
	}

	@PostMapping("/resetPassword")
	public String resetPassword(@RequestParam String token, @RequestBody String newPassword) {
		newPassword = newPassword.replaceAll("^\"|\"$", "");
		User user = userService.findByResetToken(token);
		if (user == null || user.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
			throw new RuntimeException("Invalid or expired token");
			//return "Invalid or expired token";
		}

		// Update the password
		user.setPassword(newPassword);
		// Clear the reset token after use
		user.setResetToken(null); 
		user.setResetTokenExpiry(null);
		userService.save(user);

		return "Password successfully reset";
	}
}
