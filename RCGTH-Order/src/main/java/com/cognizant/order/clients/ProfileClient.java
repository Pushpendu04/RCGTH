package com.cognizant.order.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cognizant.order.model.Profile;


@FeignClient(name = "RCGTH-Profile-Microservice" ,url = "http://localhost:8080")
public interface ProfileClient {
	
	@GetMapping("/getallprofile")
	public List<Profile> getAllProfiles();

}
