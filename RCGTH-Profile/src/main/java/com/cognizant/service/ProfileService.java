package com.cognizant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.entity.Profile;

@Service
public interface ProfileService {
	public List<Profile> getAllProfiles();

	public Profile insertProfiles(Profile profile);

	public Profile updateProfiles(Profile profile) throws ProfileNotFoundException;

	public void deleteProfiles(int id) throws ProfileNotFoundException;
	
	public Profile findByProfileId(int id) throws ProfileNotFoundException;
}
