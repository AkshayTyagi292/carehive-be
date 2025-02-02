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
	
	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	@Column(name="hourlyprice")
	private double hourlyPrice;

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

	public Services(String serviceTitle, double hourlyPrice) {
		super();
		this.serviceTitle = serviceTitle;
		this.hourlyPrice = hourlyPrice;
	}
	
	
}
