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
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}
	
	

}
