package com.carehive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.carehive.entities.User;
import com.carehive.entities.UserType;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	
	
	User findByEmail(String email);

	User findByResetToken(String token);

	List<User> findByUserType(UserType caretaker);
}
