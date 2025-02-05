package com.carehive.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carehive.entities.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Integer> {

	List<Bookings> findAllBycaretakerId(int caretakerId);


	List<Bookings> findAllByelderId(int elderId);
	
	

}
