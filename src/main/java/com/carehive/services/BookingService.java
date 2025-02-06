package com.carehive.services;

import java.util.List;

import com.carehive.entities.BookingStatus;
import com.carehive.entities.Bookings;
import com.carehive.entities.UserType;

public interface BookingService {

	public Bookings create(Bookings booking);

	public List<Bookings> allBookings(int id, UserType userType);

	public Bookings updateBookingStatus(int id, BookingStatus status);

	public Bookings getBookingDetails(int bookingId);

}
