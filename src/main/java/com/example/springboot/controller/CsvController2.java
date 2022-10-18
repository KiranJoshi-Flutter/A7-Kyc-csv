package com.example.springboot.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.model.AddressDetails;
import com.example.springboot.model.BankDetail;
import com.example.springboot.model.Biometrics;
import com.example.springboot.model.DocumentDetail;
import com.example.springboot.model.FamilyDetail;
import com.example.springboot.model.GuardianDetails;
import com.example.springboot.model.OccupationDetail;
import com.example.springboot.model.PersonDetail;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@RestController
public class CsvController2 {

	@PostMapping("/uploadKycCsv2")
	public List<PersonDetail> uploadKycCsv(@RequestParam("file") MultipartFile file) throws Exception {
		List<PersonDetail> personDetails = new ArrayList<>();

		InputStream inputStream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(false);
		CsvParser parser = new CsvParser(setting);
		List<Record> parseAllRecords = parser.parseAllRecords(inputStream);

		List<List<String>> matrix = new ArrayList<List<String>>();
		List<FamilyDetail> familyDetails = new ArrayList<>();
		List<DocumentDetail> documentDetails = new ArrayList<>();
		PersonDetail personDetail = new PersonDetail();

		String prevCode = null;
		for (Record record : parseAllRecords) {
			System.out.println(record);
			String code = record.getValue(1, String.class);

			if (code == null) {
				code = prevCode;
			} else
				prevCode = code;

			List<String> row = new ArrayList<String>();

			switch (code) {
			case "PD":
				personDetail = getDataForPD(code, record, row);
				personDetails.add(personDetail);
				break;

			case "BM":
				Biometrics biometrics = new Biometrics();
				biometrics = getDataForBM(code, record, row);
				personDetail.setBiometrics(biometrics);
				break;

			case "FD":
				getDataForFD(code, record, row, personDetail, familyDetails);
				break;

			case "DD":
				getDataForDD(code, record, row, personDetail, documentDetails);
				break;

			case "AD":
				getDataForAD(code, record, row);
				break;

			case "BD":
				getDataForBD(code, record, row, personDetail);
				break;

			case "OD":
				OccupationDetail occupationDetail = new OccupationDetail();
				occupationDetail = getDataForOD(code, record, row);
				personDetail.setOccupationDetail(occupationDetail);
				break;

			case "GD":
				GuardianDetails guardianDetails = new GuardianDetails();
				guardianDetails = getDataForGD(code, record, row);
				personDetail.setGuardianDetails(guardianDetails);
				break;

			default:
				break;
			}
			matrix.add(row);

		}

		return personDetails;
	}

	private GuardianDetails getDataForGD(String code, Record record, List<String> row) {

		GuardianDetails guardianDetails = new GuardianDetails();

		String boid = record.getValue(2, String.class);
		String photoFieldId = record.getValue(3, String.class);
		String firstNameEng = record.getValue(4, String.class);
		String middelNameEng = record.getValue(5, String.class);
		String lastNameEng = record.getValue(6, String.class);
		String relationshipWithApplicant = record.getValue(7, String.class);
		String country = record.getValue(8, String.class);
		String State = record.getValue(9, String.class);
		String district = record.getValue(10, String.class);
		String muncipality = record.getValue(11, String.class);
		String ward = record.getValue(12, String.class);
		String tole = record.getValue(13, String.class);
		String blockNo = record.getValue(14, String.class);
		String telephone = record.getValue(15, String.class);
		String email = record.getValue(16, String.class);
		String mobileNo = record.getValue(17, String.class);
		String citizenshipId = record.getValue(18, String.class);
		String issuedDateBs = record.getValue(19, String.class);
		String issuedDateAd = record.getValue(20, String.class);
		String issuedFrom = record.getValue(21, String.class);
		String fileId = record.getValue(22, String.class);
		String backFileId = record.getValue(23, String.class);

		guardianDetails.setBoid(boid);

		PersonDetail personDetail = new PersonDetail();
		personDetail.setPhotoFileId(photoFieldId);
		personDetail.setFirstNameEng(firstNameEng);
		personDetail.setMiddelNameEng(middelNameEng);
		personDetail.setLastNameEng(lastNameEng);
		personDetail.setBiometrics(null);
		personDetail.setFamilyDetailList(null);
		personDetail.setBankDetails(null);
		personDetail.setDocumentDetailList(null);
		personDetail.setOccupationDetail(null);
//		personDetail.setGuardianDetails(null);
		guardianDetails.setPersonDetail(personDetail);

		guardianDetails.setRelationshipWithApplicant(relationshipWithApplicant);

		AddressDetails addressDetails = new AddressDetails();
		addressDetails.setCountry(country);
		addressDetails.setState(State);
		addressDetails.setDistrict(district);
		addressDetails.setMuncipality(muncipality);
		addressDetails.setWard(ward);
		addressDetails.setTole(tole);
		addressDetails.setBlockNo(blockNo);
		addressDetails.setTelephoneNo(telephone);
		addressDetails.setEmailId(email);
		addressDetails.setMobileNo(mobileNo);
		guardianDetails.setAddressDetails(addressDetails);

		DocumentDetail documentDetail = new DocumentDetail();
		documentDetail.setDocumentType("CZ");
		documentDetail.setDocumentId(citizenshipId);
		documentDetail.setIssuedDateBs(issuedDateBs);
		documentDetail.setIssuedDateAd(issuedDateAd);
		documentDetail.setIssuedFrom(issuedFrom);
		documentDetail.setFileId(fileId);
		documentDetail.setBackFielId(backFileId);
		guardianDetails.setDocumentDetail(documentDetail);

		return guardianDetails;

	}

	private OccupationDetail getDataForOD(String code, Record record, List<String> row) {

		OccupationDetail occupationDetail = new OccupationDetail();

		String boid = record.getValue(2, String.class);
		String occupationType = record.getValue(3, String.class);
		String bussinessType = record.getValue(4, String.class);
		String organizationName = record.getValue(5, String.class);
		String address = record.getValue(6, String.class);
		String designation = record.getValue(7, String.class);
		String idNoOfEmployee = record.getValue(8, String.class);
		String financialDetails = record.getValue(9, String.class);
		String involvementIn = record.getValue(10, String.class);
		String partiallyExposedPerson = record.getValue(11, String.class);

		occupationDetail.setBoid(boid);
		occupationDetail.setOccupationType(occupationType);
		occupationDetail.setBussinessType(bussinessType);
		occupationDetail.setOrganizationName(organizationName);
		occupationDetail.setAddress(address);
		occupationDetail.setDesignation(designation);
		occupationDetail.setIdNoOfEmployee(idNoOfEmployee);
		occupationDetail.setFinancialDetails(financialDetails);
		occupationDetail.setInvolvementIn(involvementIn);
		occupationDetail.setPartiallyExposedPerson(partiallyExposedPerson);

		return occupationDetail;

	}

	private void getDataForBD(String code, Record record, List<String> row, PersonDetail personDetail) {

		BankDetail bankDetail = new BankDetail();

		String boid = record.getValue(2, String.class);
		String accountType = record.getValue(3, String.class);
		String bank = record.getValue(4, String.class);
		String bankBranch = record.getValue(5, String.class);
		String accountNo = record.getValue(6, String.class);

		bankDetail.setBoid(boid);
		bankDetail.setAccountType(accountType);
		bankDetail.setBank(bank);
		bankDetail.setBankBranch(bankBranch);
		bankDetail.setAccountNo(accountNo);

		personDetail.bankDetails.add(bankDetail);

	}

	private void getDataForAD(String code, Record record, List<String> row) {

		String boid = record.getValue(2, String.class);
		String country = record.getValue(3, String.class);
		String state = record.getValue(4, String.class);
		String district = record.getValue(5, String.class);
		String muncipality = record.getValue(6, String.class);
		String ward = record.getValue(7, String.class);
		String tole = record.getValue(8, String.class);
		String blockNo = record.getValue(9, String.class);
		String telephoneNo = record.getValue(10, String.class);
		String emailId = record.getValue(11, String.class);
		String mobileNo = record.getValue(12, String.class);
		String gps = record.getValue(13, String.class);
		String isPermSame = record.getValue(14, String.class);

		AddressDetails addressDetails = new AddressDetails();

		addressDetails.setBoid(boid);
		addressDetails.setCountry(country);
		addressDetails.setState(state);
		addressDetails.setDistrict(district);
		addressDetails.setMuncipality(muncipality);
		addressDetails.setWard(ward);
		addressDetails.setTole(tole);

		String checkkkkkk2 = record.getValue(2, String.class);
		String checkkkkkk3 = record.getValue(3, String.class);
		String checkkkkk4 = record.getValue(4, String.class);

		row.add(checkkkkkk2);
		row.add(checkkkkkk3);
		row.add(checkkkkk4);

		System.out.println(row);

		System.out.println("AD check");
	}

	private void getDataForDD(String code, Record record, List<String> row, PersonDetail personDetail,
			List<DocumentDetail> documentDetails) {

		String documentType = record.getValue(2, String.class);
		String documentId = record.getValue(3, String.class);
		String issuedDateBs = record.getValue(4, String.class);
		String issuedDateAd = record.getValue(5, String.class);
		String issuedFrom = record.getValue(6, String.class);
		String fileId = record.getValue(7, String.class);
		String backFielId = record.getValue(8, String.class);

		if (documentType.equals("NID")) {
			DocumentDetail documentDetail = new DocumentDetail();

			documentDetail.setDocumentType(documentType);
			documentDetail.setDocumentId(documentId);
			documentDetail.setIssuedDateBs(issuedDateBs);
			documentDetail.setIssuedDateAd(issuedDateAd);
			documentDetail.setIssuedFrom(issuedFrom);
			documentDetail.setFileId(fileId);
			documentDetail.setBackFielId(backFielId);

			personDetail.documentDetailList.add(documentDetail);
		} else if (documentType.equals("CZ")) {
			DocumentDetail documentDetail = new DocumentDetail();

			documentDetail.setDocumentType(documentType);
			documentDetail.setDocumentId(documentId);
			documentDetail.setIssuedDateBs(issuedDateBs);
			documentDetail.setIssuedDateAd(issuedDateAd);
			documentDetail.setIssuedFrom(issuedFrom);
			documentDetail.setFileId(fileId);
			documentDetail.setBackFielId(backFielId);

			personDetail.documentDetailList.add(documentDetail);

		} else if (documentType.equals("BC")) {
			DocumentDetail documentDetail = new DocumentDetail();

			documentDetail.setDocumentType(documentType);
			documentDetail.setDocumentId(documentId);
			documentDetail.setIssuedDateBs(issuedDateBs);
			documentDetail.setIssuedDateAd(issuedDateAd);
			documentDetail.setIssuedFrom(issuedFrom);
			documentDetail.setFileId(fileId);
			documentDetail.setBackFielId(backFielId);

			personDetail.documentDetailList.add(documentDetail);
		} else if (documentType.equals("NR")) {
			DocumentDetail documentDetail = new DocumentDetail();

			documentDetail.setDocumentType(documentType);
			documentDetail.setDocumentId(documentId);
			documentDetail.setIssuedDateBs(issuedDateBs);
			documentDetail.setIssuedDateAd(issuedDateAd);
			documentDetail.setIssuedFrom(issuedFrom);
			documentDetail.setFileId(fileId);
			documentDetail.setBackFielId(backFielId);

			personDetail.documentDetailList.add(documentDetail);
		} else if (documentType.equals("PP")) {
			DocumentDetail documentDetail = new DocumentDetail();

			documentDetail.setDocumentType(documentType);
			documentDetail.setDocumentId(documentId);
			documentDetail.setIssuedDateBs(issuedDateBs);
			documentDetail.setIssuedDateAd(issuedDateAd);
			documentDetail.setIssuedFrom(issuedFrom);
			documentDetail.setFileId(fileId);
			documentDetail.setBackFielId(backFielId);

			personDetail.documentDetailList.add(documentDetail);
		} else if (documentType.equals("O")) {
			DocumentDetail documentDetail = new DocumentDetail();

			documentDetail.setDocumentType(documentType);
			documentDetail.setDocumentId(documentId);
			documentDetail.setIssuedDateBs(issuedDateBs);
			documentDetail.setIssuedDateAd(issuedDateAd);
			documentDetail.setIssuedFrom(issuedFrom);
			documentDetail.setFileId(fileId);
			documentDetail.setBackFielId(backFielId);

			personDetail.documentDetailList.add(documentDetail);
		}
	}

	private void getDataForFD(String code, Record record, List<String> row, PersonDetail personDetail2,
			List<FamilyDetail> familyDetails) {

		String type = record.getValue(2, String.class);

		String firstNameEng = record.getValue(3, String.class);
		String middelNameEng = record.getValue(4, String.class);
		String lastNameEng = record.getValue(5, String.class);
		String firstNameNep = record.getValue(6, String.class);
		String middleNameNep = record.getValue(7, String.class);
		String lastNameNep = record.getValue(8, String.class);

		if (type.equals("GF")) {

			FamilyDetail familyDetail = new FamilyDetail();
			familyDetail.setType(type);
			PersonDetail personDetail = new PersonDetail();
			personDetail.setFirstNameEng(firstNameEng);
			personDetail.setMiddelNameEng(middelNameEng);
			personDetail.setLastNameEng(lastNameEng);

			personDetail.setFirstNameNep(firstNameNep);
			personDetail.setMiddleNameNep(middleNameNep);
			personDetail.setLastNameNep(lastNameNep);
			personDetail.setBiometrics(null);
			personDetail.setFamilyDetailList(null);
			personDetail.setBankDetails(null);
			personDetail.setDocumentDetailList(null);
			personDetail.setOccupationDetail(null);

			familyDetail.setPersonDetail(personDetail);

			personDetail2.familyDetailList.add(familyDetail);

		} else if (type.equals("F")) {

			FamilyDetail familyDetail = new FamilyDetail();
			familyDetail.setType(type);
			PersonDetail personDetail = new PersonDetail();
			personDetail.setFirstNameEng(firstNameEng);
			personDetail.setMiddelNameEng(middelNameEng);
			personDetail.setLastNameEng(lastNameEng);

			personDetail.setFirstNameNep(firstNameNep);
			personDetail.setMiddleNameNep(middleNameNep);
			personDetail.setLastNameNep(lastNameNep);
			personDetail.setBiometrics(null);
			personDetail.setFamilyDetailList(null);
			personDetail.setBankDetails(null);
			personDetail.setDocumentDetailList(null);
			personDetail.setOccupationDetail(null);

			familyDetail.setPersonDetail(personDetail);

			personDetail2.familyDetailList.add(familyDetail);

		} else if (type.equals("M")) {

			FamilyDetail familyDetail = new FamilyDetail();
			familyDetail.setType(type);
			PersonDetail personDetail = new PersonDetail();
			personDetail.setFirstNameEng(firstNameEng);
			personDetail.setMiddelNameEng(middelNameEng);
			personDetail.setLastNameEng(lastNameEng);

			personDetail.setFirstNameNep(firstNameNep);
			personDetail.setMiddleNameNep(middleNameNep);
			personDetail.setLastNameNep(lastNameNep);
			personDetail.setBiometrics(null);
			personDetail.setFamilyDetailList(null);
			personDetail.setBankDetails(null);
			personDetail.setDocumentDetailList(null);
			personDetail.setOccupationDetail(null);

			familyDetail.setPersonDetail(personDetail);

			personDetail2.familyDetailList.add(familyDetail);

		}

	}

	private PersonDetail getDataForPD(String code, Record record, List<String> row) {

		PersonDetail personDetail = new PersonDetail();

		String boid = record.getValue(2, String.class);
		String photoFieldId = record.getValue(3, String.class);
		String firstNameEng = record.getValue(4, String.class);
		String middelNameEng = record.getValue(5, String.class);
		String lastNameEng = record.getValue(6, String.class);
		String firstNameNep = record.getValue(7, String.class);
		String middleNameNep = record.getValue(8, String.class);
		String lastNameNep = record.getValue(9, String.class);
		String dateOfBirthBs = record.getValue(10, String.class);
		String dateOfBirthAd = record.getValue(11, String.class);
		String gender = record.getValue(12, String.class);
		String nationality = record.getValue(13, String.class);
		String pan = record.getValue(14, String.class);
		String nrn = record.getValue(15, String.class);
		String maritialStatus = record.getValue(16, String.class);
		String differentlyAbled = record.getValue(17, String.class);
		String otherBoids = record.getValue(18, String.class);

		personDetail.setBoid(boid);
		personDetail.setPhotoFileId(photoFieldId);
		personDetail.setFirstNameEng(firstNameEng);
		personDetail.setMiddelNameEng(middelNameEng);
		personDetail.setLastNameEng(lastNameEng);

		personDetail.setFirstNameNep(firstNameNep);
		personDetail.setMiddleNameNep(middleNameNep);
		personDetail.setLastNameNep(lastNameNep);

		personDetail.setDateOfBirthBs(dateOfBirthBs);
		personDetail.setDateOfBirthAd(dateOfBirthAd);

		personDetail.setGender(gender);
		personDetail.setNationality(nationality);
		personDetail.setPan(pan);
		personDetail.setNrn(nrn);
		personDetail.setMaritialStatus(maritialStatus);
		personDetail.setDifferentlyAbled(differentlyAbled);

		personDetail.setOtherBoids(otherBoids);

		return personDetail;

	}

	private Biometrics getDataForBM(String code, Record record, List<String> row) {

		Biometrics biometrics = new Biometrics();

		String fingerPrintIsoLeft = record.getValue(2, String.class);
		String fingerPrintIsoRight = record.getValue(3, String.class);
		String leftFileId = record.getValue(4, String.class);
		String rightFileId = record.getValue(5, String.class);
		String signatureFileId = record.getValue(6, String.class);

		row.add(fingerPrintIsoLeft);
		row.add(fingerPrintIsoRight);
		row.add(leftFileId);
		row.add(rightFileId);
		row.add(signatureFileId);

		biometrics.setFingerPrintIsoLeft(fingerPrintIsoLeft);
		biometrics.setFingerPrintIsoRight(fingerPrintIsoRight);
		biometrics.setLeftFileId(leftFileId);
		biometrics.setRightFileId(rightFileId);
		biometrics.setSignatureFileId(signatureFileId);

		return biometrics;

	}

}
