package com.example.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GuardianDetails {

	private String boid;

//	private String photoFileId;
//	private String firstName;
//	private String middleName;
//	private String lastName;

	private PersonDetail personDetail = new PersonDetail();

	private String relationshipWithApplicant;

	private AddressDetails addressDetails = new AddressDetails();

	private DocumentDetail documentDetail = new DocumentDetail();

//	private String country;
//	private String State;
//	private String district;
//	private String muncipality;
//	private String ward;
//	private String tole;
//	private String blockNo;
//	private String telephone;
//	private String email;
//	private String mobileNo;

//	private String citizenshipId;    ??????
//	private String issuedDateBs;
//	private String issuedDateAd;
//	private String issuedFrom;
//	private String fileId;
//	private String backFileId;

}
