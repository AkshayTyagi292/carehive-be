package com.carehive.services;

import com.carehive.entities.User;

public interface UserService {
        public User register(User user);
        public User getDetails(int id);
		public User updateUser(User user, int id);
}
