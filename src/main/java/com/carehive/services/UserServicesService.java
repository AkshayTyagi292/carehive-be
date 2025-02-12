package com.carehive.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carehive.entities.UsersServices;
import com.carehive.repositories.UserServicesRepository;

import jakarta.transaction.Transactional;

@Service
public class UserServicesService {
	
	@Autowired
	UserServicesRepository userServicesRepository;
	
	@Transactional
    public void updateUserServices(int userId, List<Integer> serviceIds) {
        // Get existing service IDs for the user
        List<UsersServices> existingUserServices = userServicesRepository.findByUserId(userId);
        List<Integer> existingServiceIds = existingUserServices.stream()
                .map(UsersServices::getServiceId)
                .collect(Collectors.toList());

        // Remove services that are no longer selected
        for (UsersServices userService : existingUserServices) {
            if (!serviceIds.contains(userService.getServiceId())) {
                userServicesRepository.delete(userService);
            }
        }

        // Add new services that are not already present
        for (int serviceId : serviceIds) {
            if (!existingServiceIds.contains(serviceId)) {
                userServicesRepository.save(new UsersServices(userId, serviceId));
            }
        }
    }

}
