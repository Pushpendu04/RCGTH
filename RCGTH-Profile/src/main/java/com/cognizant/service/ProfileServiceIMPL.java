package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Profile;
import com.cognizant.repo.ProfileRepository;

@Service
public class ProfileServiceIMPL implements ProfileService {

	@Autowired
	ProfileRepository repo;
	
	@Override
	public List<Profile> getAllProfiles() {
		return repo.findAll();
	}

	@Override
	public Profile insertProfiles(Profile profile) {
		return repo.save(profile);
	}

	@Override
	public Profile updateProfiles(Profile profile) throws ProfileNotFoundException {
		if(repo.findById(profile.getProfileid()).isPresent()) {
			return repo.save(profile);
		}else {
			throw new ProfileNotFoundException("Profile Not Found!");
		}
	}

	@Override
	public void deleteProfiles(int id) throws ProfileNotFoundException {
		if(repo.findById(id).isPresent()) {
			repo.deleteById(id);
		}else {
			throw new ProfileNotFoundException("Profile Not Found!");
		}
	}

	@Override
	public Profile findByProfileId(int id) throws ProfileNotFoundException {
		if(repo.findById(id).isPresent()) {
			return repo.findById(id).get();
		}else {
			throw new ProfileNotFoundException("Profile Not Found!");
		}
	}

}
