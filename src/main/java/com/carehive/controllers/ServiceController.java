package com.carehive.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carehive.entities.Services;
import com.carehive.services.ServicesService;

@RequestMapping("/service")
@RestController
public class ServiceController {

    @Autowired
    ServicesService servicesService;

    @PostMapping("/create")
    public Services addService(@RequestBody Services service) {
        return servicesService.createService(service);
    }

    @PatchMapping("/update/{id}")
    public Services updateService(@PathVariable int id, @RequestBody Services service) {
        return servicesService.updateService(id, service);
    }

    @GetMapping("/list")
    public List<Services> services() {
        return servicesService.AllServices();
    }

    @GetMapping("/{id}")
    public Services getService(@PathVariable int id) {
        return servicesService.getService(id);
    }
}
