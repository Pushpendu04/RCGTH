package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Profile;
import com.cognizant.service.ProfileNotFoundException;
import com.cognizant.service.ProfileService;

@RestController
public class ProfileController {

	@Autowired
	ProfileService service;

	@Autowired
	private MessageChannel output;

	@GetMapping("/getallprofile")
	public List<Profile> getAllProfiles() {
		return service.getAllProfiles();
	}

	@PostMapping("/insertprofile")
	public Profile insertProfiles(@RequestBody Profile profile) {
		//output.send(MessageBuilder.withPayload(profile).build());
		return service.insertProfiles(profile);
	}

	@PutMapping("/updateprofile")
	public Profile updateProfiles(@RequestBody Profile profile) throws ProfileNotFoundException {
		return service.updateProfiles(profile);
	}

	@DeleteMapping("/deleteprofile/{id}")
	public void deleteProfiles(@PathVariable int id) throws ProfileNotFoundException {
		service.deleteProfiles(id);
	}

}
