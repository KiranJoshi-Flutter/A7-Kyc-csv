package com.example.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data

@Getter
@Setter
@NoArgsConstructor
public class OccupationDetail {

	private String boid;

	private String occupationType;
	private String bussinessType;
	private String organizationName;
	private String address;
	private String designation;
	private String idNoOfEmployee;
	private String financialDetails;
	private String involvementIn;
	private String partiallyExposedPerson;
}
