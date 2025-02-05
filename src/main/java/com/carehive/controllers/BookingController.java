package com.carehive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carehive.entities.Bookings;
import com.carehive.entities.UserType;
import com.carehive.services.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/create")
	public Bookings create(@RequestBody Bookings booking) {
		
		return bookingService.create(booking);
		
	}
	
	
	@GetMapping("/list/{id}/{userType}")
	public List<Bookings> allBookings(@PathVariable int id, @PathVariable UserType userType){
		 return bookingService.allBookings(id,userType);
	}

}
