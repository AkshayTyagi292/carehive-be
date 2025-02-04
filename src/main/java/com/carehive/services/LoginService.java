package com.carehive.services;



import java.util.Map;

import com.carehive.entities.User;

public interface LoginService {

	public User login(User user);

	public String resetPassword(String token, String newPassword);

	public String forgotPassword(Map<String, String> request);

}
