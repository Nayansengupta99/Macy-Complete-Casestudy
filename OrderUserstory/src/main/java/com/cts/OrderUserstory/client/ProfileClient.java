package com.cts.OrderUserstory.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.cts.OrderUserstory.DTO.ProfileModel;

@FeignClient(name="profile-service",url="${feign.url}")
public interface ProfileClient {
	@GetMapping("/details")
	public List<ProfileModel> getAllProfileDetails();
	
}
