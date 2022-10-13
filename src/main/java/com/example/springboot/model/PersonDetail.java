package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

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

	private Biometrics biometrics = new Biometrics();
//	private List<FamilyDetail> familyDetailList = new ArrayList<FamilyDetail>();
	public List<FamilyDetail> familyDetailList = new ArrayList<FamilyDetail>();
//	private List<DocumentDetails> documentDetailList = new ArrayList<>();
//	private List<AddressDetails> addressDetailList = new ArrayList<>();
//	private BankDetails bankDetails = new BankDetails();
//	private List<OccupationDetails> occupationDetailList = new ArrayList<>();
//	private GuardianDetails guardianDetails = new GuardianDetails();

}
