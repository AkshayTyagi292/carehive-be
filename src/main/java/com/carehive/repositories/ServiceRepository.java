package com.carehive.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carehive.entities.Services;

@Repository
public interface ServiceRepository extends JpaRepository<Services, Integer> {

}
