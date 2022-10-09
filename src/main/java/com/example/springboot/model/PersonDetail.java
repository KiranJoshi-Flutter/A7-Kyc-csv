package com.example.springboot.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class PersonDetail {

	private String boid;

	private String photoFileId;
	private String firstNameEng;
	private String middelNameEng;
	private String lastNameEng;

	private String firstNameNep;
	private String middleNameNep;
	private String lastNameNep;

	private String dateOfBirthBs;
	private String dateOfBirthAd;

	private String gender;
	private String nationality;
	private String pan;
	private String nrn;
	private String maritialStatus;
	private String differentlyAbled;

	private String otherBoids;

}
