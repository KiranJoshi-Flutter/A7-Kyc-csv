package com.example.springboot.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
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
	public List<DocumentDetail> documentDetailList = new ArrayList<>();
//	private List<AddressDetails> addressDetailList = new ArrayList<>();
	public List<AddressDetails> addressDetailList = new ArrayList<>();
//	private AddressDetails addressDetail = new AddressDetails();
//	private BankDetail bankDetail = new BankDetail();
	public List<BankDetail> bankDetails = new ArrayList<>();
//	private List<OccupationDetails> occupationDetailList = new ArrayList<>();
	private OccupationDetail occupationDetail = new OccupationDetail();

	private GuardianDetails guardianDetails;
}
