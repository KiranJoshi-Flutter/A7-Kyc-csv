package com.example.springboot.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@RestController
public class CsvController2 {

	@PostMapping("/uploadKycCsv2")
	public String uploadKycCsv(@RequestParam("file") MultipartFile file) throws Exception {

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
				getDataForPD(code, record, row);
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

		return "Upload Successful !!!";
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

	private void getDataForPD(String code, Record record, List<String> row) {

		String check2 = record.getValue(2, String.class);
		String check3 = record.getValue(3, String.class);
		String check4 = record.getValue(4, String.class);

		row.add(check2);
		row.add(check3);
		row.add(check4);

		System.out.println(row);

		System.out.println("PD check updated");

	}

	private void getDataForBM(String code, Record record, List<String> row) {

		String checkk2 = record.getValue(2, String.class);
		String checkk3 = record.getValue(3, String.class);
		String checkk4 = record.getValue(4, String.class);
		String checkk5 = record.getValue(5, String.class);
		String checkk6 = record.getValue(6, String.class);
		String checkk7 = record.getValue(7, String.class);

		row.add(checkk2);
		row.add(checkk3);
		row.add(checkk4);
		row.add(checkk5);
		row.add(checkk6);
		row.add(checkk7);

		System.out.println(row);

		System.out.println("BM check");

	}

}
