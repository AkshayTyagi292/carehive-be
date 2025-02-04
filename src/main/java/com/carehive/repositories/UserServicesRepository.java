package com.carehive.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carehive.entities.UsersServices;

import jakarta.transaction.Transactional;


@Repository
public interface UserServicesRepository extends JpaRepository<UsersServices, Integer> {
	
	 List<UsersServices> findByUserId(int userId);  // Fetch all services for a user

	    @Transactional
	    void deleteByUserId(int userId); 

}
