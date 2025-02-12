package com.carehive.entities;

import java.time.LocalDate;
import java.util.List;

public class UserUpdateRequest {
	
	  private UserType userType;
	    private String name;
	    private String email;
	    private String contact;
	    private String emergencyContact;
	    private String gender;
	    private LocalDate date;
	    private String password;
	    private List<Integer> serviceIds; // List of service IDs

	    // Getters and Setters
	    public UserType getUserType() { return userType; }
	    public void setUserType(UserType userType) { this.userType = userType; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getEmail() { return email; }
	    public void setEmail(String email) { this.email = email; }

	    public String getContact() { return contact; }
	    public void setContact(String contact) { this.contact = contact; }

	    public String getEmergencyContact() { return emergencyContact; }
	    public void setEmergencyContact(String emergencyContact) { this.emergencyContact = emergencyContact; }

	    public String getGender() { return gender; }
	    public void setGender(String gender) { this.gender = gender; }

	    public LocalDate getDate() { return date; }
	    public void setDate(LocalDate date) { this.date = date; }

	    public String getPassword() { return password; }
	    public void setPassword(String password) { this.password = password; }

	    public List<Integer> getServiceIds() { return serviceIds; }
	    public void setServiceIds(List<Integer> serviceIds) { this.serviceIds = serviceIds; }

}




