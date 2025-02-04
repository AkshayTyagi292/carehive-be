package com.carehive.services;

import java.util.List;

import com.carehive.entities.User;

public interface UserService {
        public User register(User user);
        public User getDetails(int id);
		public User updateUser(User user, int id, List<Integer> list);
		public List<User> getAllCaretakers();
		public User findByEmail(String email);
		public User findByResetToken(String token);
	
}
