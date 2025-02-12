package com.carehive.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class Bookings {
	
	@Id
	@GeneratedValue(generator="increment")
	@Column(name="bookingid")
	private int bookingId;
	
	  @Column(name = "elderid", nullable = false)
	    private int elderId;

	    @Column(name = "caretakerid", nullable = false)
	    private int caretakerId;
	    
	    @Column(name="serviceid",nullable=false)
	    private int serviceId;

	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	    @Column(name = "datetime", nullable = false)
	    private LocalDateTime datetime;

	    @Column(name = "bookinghrs", nullable = false)
	    private int bookingHrs;

	    @Column(name = "price", nullable = false)
	    private double price;
	    
	    @Column(name = "totalprice", nullable = false)
	    private  double totalprice;
	    

		@Enumerated(EnumType.STRING)
	    @Column(name = "status", nullable = false)
	    private BookingStatus status;

	    @Column(name = "message")
	    private String message;

		public int getBookingId() {
			return bookingId;
		}

		public void setBookingId(int bookingId) {
			this.bookingId = bookingId;
		}

		public int getElderId() {
			return elderId;
		}

		public void setElderId(int elderId) {
			this.elderId = elderId;
		}
		
		

		public int getServiceId() {
			return serviceId;
		}

		public void setServiceId(int serviceId) {
			this.serviceId = serviceId;
		}

		public int getCaretakerId() {
			return caretakerId;
		}

		public void setCaretakerId(int caretakerId) {
			this.caretakerId = caretakerId;
		}

		public LocalDateTime getDatetime() {
			return datetime;
		}

		public void setDatetime(LocalDateTime datetime) {
			this.datetime = datetime;
		}

		public int getBookingHrs() {
			return bookingHrs;
		}

		public void setBookingHrs(int bookingHrs) {
			this.bookingHrs = bookingHrs;
		}

		public double getPrice() {
			return price;
		}
		
		  public double getTotalprice() {
				return totalprice;
			}

			public void setTotalprice(double totalprice) {
				this.totalprice = totalprice;
			}

		public void setPrice(double price) {
			this.price = price;
		}

		public BookingStatus getStatus() {
			return status;
		}

		public void setStatus(BookingStatus status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Bookings() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Bookings(int elderId, int caretakerId,int serviceId, LocalDateTime datetime, int bookingHrs, double price,
				double totalprice, BookingStatus status, String message) {
			super();
			this.elderId = elderId;
			this.caretakerId = caretakerId;
			this.serviceId=serviceId;
			this.datetime = datetime;
			this.bookingHrs = bookingHrs;
			this.price = price;
			this.totalprice = totalprice;
			this.status = status;
			this.message = message;
		}

	
	    

}
