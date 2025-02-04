package com.carehive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carehive.entities.User;
import com.carehive.entities.UserType;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByEmail(String email);
	public	List<User> findByUserType(UserType caretaker); 
	public User findByResetToken(String token);

}
