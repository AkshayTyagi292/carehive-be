package com.carehive.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="service")
public class Services {

	public Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(generator="increment")
	@Column(name="serviceid")
	private int serviceId;
	
	@Column(name="servicetitle")
	private String serviceTitle;
	
	@Column(name="servicedescription")
	private String serviceDescription;
	
	@Column(name="hourlyprice")
	private double hourlyPrice;
	
	
	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

	public double getHourlyPrice() {
		return hourlyPrice;
	}

	public void setHourlyPrice(double hourlyPrice) {
		this.hourlyPrice = hourlyPrice;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Services(String serviceTitle, double hourlyPrice, String	serviceDescription) {
		super();
		this.serviceTitle = serviceTitle;
		this.hourlyPrice = hourlyPrice;
		this.serviceDescription=serviceDescription;
	}
	
	
}
