package com.carehive.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carehive.entities.BookingStatus;
import com.carehive.entities.Bookings;
import com.carehive.entities.UserType;
import com.carehive.repositories.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Override
	public Bookings create(Bookings booking) {
		if(booking==null) {
			throw new RuntimeException("booking failed ! please enter valid booking details");
		}		
		if(booking.getDatetime().isBefore(LocalDateTime.now())) {
			  throw new RuntimeException("Booking date time cannot be a past date time");
		}		
		booking.setTotalprice(booking.getPrice()*booking.getBookingHrs());
		 Bookings bookeddata =bookingRepository.save(booking);		 
		 return bookingRepository.findById(bookeddata.getBookingId()).orElseThrow(()->new RuntimeException("unable to book service please try agan later!"));
		 		 
	}

	@Override
	public List<Bookings> allBookings(int id, UserType userType) {
		List<Bookings> booking=new ArrayList<>();
		// TODO Auto-generated method stub
		
		if(userType==UserType.Caretaker) {
			  return bookingRepository.findAllBycaretakerId(id);
		}
		
		if(userType==userType.Elder) {
			return bookingRepository.findAllByelderId(id);
		}
		return booking;
	}

	@Override
	public Bookings updateBookingStatus(int id, BookingStatus status) {
		// TODO Auto-generated method stub		
		Bookings booking =bookingRepository.findBybookingId(id);
		if(booking==null) {
			throw new RuntimeException("booking not found!");
		}
		booking.setStatus(status);
		booking.setMessage("booking status updated sucessfully");
		return bookingRepository.save(booking);
	}

	@Override
	public Bookings getBookingDetails(int bookingId) {
		// TODO Auto-generated method stub
		Bookings booking =bookingRepository.findBybookingId(bookingId);
		if(booking ==null) {
			throw new RuntimeException("booking not found !");
			
		}
		booking.setMessage("booking details fetched sucessfully |");	
		return booking;
		
	}

	@Override
	public List<Bookings> getAllBookings() {
		return bookingRepository.findAll();
	}
	
	
	@Override
    public int countAllBookings() {
        return (int) bookingRepository.count();  // Cast the result to int
    }

}
