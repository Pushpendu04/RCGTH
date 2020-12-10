package com.cognizant.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

}
