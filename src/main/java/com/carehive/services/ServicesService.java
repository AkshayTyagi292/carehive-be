package com.carehive.services;

import java.util.List;

import com.carehive.entities.Services;

public interface ServicesService {
	public Services createService(Services service);
	public Services updateService(int serviceId,Services service);
	public Services getService(int serviceId);
	public List<Services> AllServices();
}
