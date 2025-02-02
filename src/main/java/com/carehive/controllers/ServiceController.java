package com.carehive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carehive.entities.Services;
import com.carehive.repositories.ServiceRepository;
import com.carehive.services.ServicesService;

@RequestMapping("/service")
@RestController
public class ServiceController {

	@Autowired
	ServicesService servicesSevice;
	
	@GetMapping("/list")
	public List<Services> services() {
		 return servicesSevice.AllServices();
	}
}
