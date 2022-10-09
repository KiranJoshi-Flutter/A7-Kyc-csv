package com.example.springboot.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OccupationDetails {

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
