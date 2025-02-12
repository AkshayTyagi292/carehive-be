package com.carehive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carehive.entities.BookingStatus;
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
	
	@PatchMapping("/{id}/{status}")
	@PreAuthorize("hasAuthority('CAREGIVER') or hasAuthority('ADMIN')")
	public Bookings updateBookingStatus(@PathVariable int id, @PathVariable BookingStatus status) {
		 return bookingService.updateBookingStatus(id,status);
	}
	
	@GetMapping("/{bookingId}")
	public Bookings getBookingDetails(@PathVariable int bookingId) {
		return bookingService.getBookingDetails(bookingId);
	}
	
	
	@GetMapping("/allBookings")
	public List<Bookings> allBookings(){
		return bookingService.getAllBookings();
	}
	
	
	@GetMapping("/count")
    public int getAllBookingsCount() {
        return bookingService.countAllBookings();
    }
}
