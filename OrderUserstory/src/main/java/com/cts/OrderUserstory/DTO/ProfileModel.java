package com.cts.OrderUserstory.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProfileModel {

	private Long profileId;

	private String profileName;

	private String profileType;

	private String criteriaName;

	private String criteriaValue;

	private String generateShipment;

}
