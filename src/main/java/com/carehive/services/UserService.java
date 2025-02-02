package com.carehive.services;

import java.util.List;

import com.carehive.entities.User;

public interface UserService {
        public User register(User user);
        public User getDetails(int id);
		public User updateUser(User user, int id);
		public List<User> getAllCaretakers();
		
		User findByEmail(String email);
	    User findByResetToken(String token);
	    void save(User user);
		
}
