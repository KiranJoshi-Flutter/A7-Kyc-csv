package com.example.springboot.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.springboot.model.Biometrics;
import com.example.springboot.model.PersonDetail;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@RestController
public class CsvController2 {

	List<PersonDetail> personDetails = new ArrayList<>();

	@PostMapping("/uploadKycCsv2")
	public List<PersonDetail> uploadKycCsv(@RequestParam("file") MultipartFile file) throws Exception {

		InputStream inputStream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(false);
		CsvParser parser = new CsvParser(setting);
		List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
		System.out.println("--------------------------------------------");

		List<List<String>> matrix = new ArrayList<List<String>>();

		String multiple = null;
		for (Record record : parseAllRecords) {
			System.out.println(record);
			String code = record.getValue(1, String.class);
			if (code == null) {
				code = multiple;
			}
			List<String> row = new ArrayList<String>();
			switch (code) {
			case "PD":
				PersonDetail personDetail = new PersonDetail();
				personDetail = getDataForPD(code, record, row);
				personDetails.add(personDetail);
				break;

			case "BM":
				getDataForBM(code, record, row);
				break;

			case "FD":
				multiple = getDataForFD(code, record, row);
				break;

			case "DD":
				multiple = getDataForDD(code, record, row);
				break;

			case "AD":
				getDataForAD(code, record, row);
				break;

			case "BD":
				getDataForBD(code, record, row);
				break;

			case "OD":
				getDataForOD(code, record, row);
				break;

			case "GD":
				getDataForGD(code, record, row);
				break;

			default:
				break;
			}
			matrix.add(row);
		}

		System.out.println("------------------------------------------------");

		System.out.println(matrix);

//		return "Upload Successful !!!";
		return personDetails;
	}

	private void getDataForGD(String code, Record record, List<String> row) {
		String checkkkkkkkkk2 = record.getValue(2, String.class);
		String checkkkkkkkkk3 = record.getValue(3, String.class);
		String checkkkkkkkk4 = record.getValue(4, String.class);

		row.add(checkkkkkkkkk2);
		row.add(checkkkkkkkkk3);
		row.add(checkkkkkkkk4);

		System.out.println(row);

		System.out.println("GD check");

	}

	private void getDataForOD(String code, Record record, List<String> row) {
		String checkkkkkkkk2 = record.getValue(2, String.class);
		String checkkkkkkkk3 = record.getValue(3, String.class);
		String checkkkkkkk4 = record.getValue(4, String.class);

		row.add(checkkkkkkkk2);
		row.add(checkkkkkkkk3);
		row.add(checkkkkkkk4);

		System.out.println(row);

		System.out.println("OD check");

	}

	private void getDataForBD(String code, Record record, List<String> row) {
		String checkkkkkkk2 = record.getValue(2, String.class);
		String checkkkkkkk3 = record.getValue(3, String.class);
		String checkkkkkk4 = record.getValue(4, String.class);

		row.add(checkkkkkkk2);
		row.add(checkkkkkkk3);
		row.add(checkkkkkk4);

		System.out.println(row);

		System.out.println("BD check");

	}

	private void getDataForAD(String code, Record record, List<String> row) {
		String checkkkkkk2 = record.getValue(2, String.class);
		String checkkkkkk3 = record.getValue(3, String.class);
		String checkkkkk4 = record.getValue(4, String.class);

		row.add(checkkkkkk2);
		row.add(checkkkkkk3);
		row.add(checkkkkk4);

		System.out.println(row);

		System.out.println("AD check");
	}

	private String getDataForDD(String code, Record record, List<String> row) {
		String checkkkk2 = record.getValue(2, String.class);
		String checkkkk3 = record.getValue(3, String.class);
		String checkkkk4 = record.getValue(4, String.class);

		row.add(checkkkk2);
		row.add(checkkkk3);
		row.add(checkkkk4);

		String multiple = "DD";

		System.out.println(row);

		System.out.println("DD check");

		return multiple;
	}

	private String getDataForFD(String code, Record record, List<String> row) {

		String checkkk2 = record.getValue(2, String.class);
		String checkkk3 = record.getValue(3, String.class);
		String checkkk4 = record.getValue(4, String.class);

		row.add(checkkk2);
		row.add(checkkk3);
		row.add(checkkk4);

		String multiple = "FD";

		System.out.println(row);

		System.out.println("FD check");

		return multiple;

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

//		row.add(boid);
//		row.add(photoFieldId);
//		row.add(firstNameEng);

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

//		System.out.println(row);
//
//		System.out.println("PD check");
//
//		System.out.println("-------------");
//		System.out.println(personDetail);
//		System.out.println("-------------");

		return personDetail;

	}

	private Biometrics getDataForBM(String code, Record record, List<String> row) {

		Biometrics biometrics = new Biometrics();

		String checkk2 = record.getValue(2, String.class);
		String checkk3 = record.getValue(3, String.class);
		String checkk4 = record.getValue(4, String.class);
		String checkk5 = record.getValue(5, String.class);
		String checkk6 = record.getValue(6, String.class);

		row.add(checkk2);
		row.add(checkk3);
		row.add(checkk4);
		row.add(checkk5);
		row.add(checkk6);

		biometrics.setFingerPrintIsoLeft(checkk2);
		biometrics.setFingerPrintIsoRight(checkk3);
		biometrics.setLeftFileId(checkk4);
		biometrics.setRightFileId(checkk5);
		biometrics.setSignatureFileId(checkk6);

//		System.out.println(row);
//
//		System.out.println("BM check");
//
//		System.out.println("-------------");
//		System.out.println(biometrics);
//		System.out.println("-------------");

		return biometrics;

	}

}
