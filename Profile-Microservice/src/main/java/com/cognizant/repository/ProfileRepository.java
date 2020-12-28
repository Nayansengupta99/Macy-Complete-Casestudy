package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.model.ProfileModel;

public interface ProfileRepository  extends JpaRepository<ProfileModel,Long>{


}
