package com.carehive.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="userservices")
public class UsersServices {
	
	
	 @Id
	    @GeneratedValue(generator = "increment")
	    private int id;

	    @Column(name = "userid", nullable = false)
	    private int userId;

	    @Column(name = "serviceid", nullable = false)
	    private int serviceId;

	    public UsersServices() {}

	    public UsersServices(int userId, int serviceId) {
	        this.userId = userId;
	        this.serviceId = serviceId;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public int getServiceId() {
			return serviceId;
		}

		public void setServiceId(int serviceId) {
			this.serviceId = serviceId;
		}

	    
}
