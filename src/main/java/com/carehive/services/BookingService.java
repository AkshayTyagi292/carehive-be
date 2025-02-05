package com.carehive.services;

import java.util.List;

import com.carehive.entities.Bookings;
import com.carehive.entities.UserType;

public interface BookingService {

	public Bookings create(Bookings booking);

	public List<Bookings> allBookings(int id, UserType userType);

}
