package com.carehive.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(generator="increment")
	@Column(name="id")
	private int id;
	
	
	
	@Column(name="usertype")
	@Enumerated(EnumType.STRING)  
	private UserType userType;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="contact")
	private String contact;
	
	@Column(name="emergencycontact")
	private String emergencyContact;
	
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	@Column(name="gender")
	private String gender;
	
	

	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(name="date", columnDefinition = "DATE")
	private LocalDate date;
	 
	 @Column(name="password")
	 private String password;
	 
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User( UserType userType, String name, String email, String contact, String emergencyContact,
			String gender, LocalDate date, String password) {
		super();
	
		this.userType = userType;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.emergencyContact = emergencyContact;
		this.gender = gender;
		this.date = date;
		this.password = password;
	}
	

}
