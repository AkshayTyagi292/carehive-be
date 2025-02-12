package com.carehive.services;

import java.util.List;

import com.carehive.entities.User;
import com.carehive.entities.UserType;
import com.carehive.entities.UserUpdateRequest;

public interface UserService {
        public User register(User user);
        public UserUpdateRequest getDetails(int id);
		public User updateUser(User user, int id, List<Integer> list);
		public List<User> getAllCaretakers();
		public User findByEmail(String email);
		public User findByResetToken(String token);
		
		
		public int countByUserType(UserType userType);
	
}
