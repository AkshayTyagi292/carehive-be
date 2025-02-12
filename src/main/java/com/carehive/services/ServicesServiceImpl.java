package com.carehive.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carehive.entities.Services;
import com.carehive.repositories.ServiceRepository;

@Service
public class ServicesServiceImpl implements ServicesService {
	
	
	
@Autowired	
	ServiceRepository serviceRepository;

	@Override
	public List<Services> AllServices() {
		return serviceRepository.findAll();
	}

	@Override
    public Services createService(Services service) {
        return serviceRepository.save(service);
    }

	@Override
    public Services updateService(int serviceId, Services serviceDetails) {
        Services existingService = serviceRepository.findById(serviceId).orElse(null);
        
        if (existingService == null) {
            return null;
        }
        existingService.setServiceTitle(serviceDetails.getServiceTitle());
        existingService.setServiceDescription(serviceDetails.getServiceDescription());
        existingService.setHourlyPrice(serviceDetails.getHourlyPrice());
        return serviceRepository.save(existingService);
    }

	@Override
	public Services getService(int serviceId) {
		Services service = serviceRepository.findById(serviceId).get();
		if(service ==null) {
			throw new RuntimeException("service not found !");
			
		}
		return service;
	}
	
	

}
