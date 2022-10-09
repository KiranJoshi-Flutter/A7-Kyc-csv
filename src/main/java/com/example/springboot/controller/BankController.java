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
public class BankController {

	@PostMapping("/upload")
	public String uploadData(@RequestParam("file") MultipartFile file) throws Exception {

		InputStream inputStream = file.getInputStream();
		CsvParserSettings setting = new CsvParserSettings();
		setting.setHeaderExtractionEnabled(false);
		CsvParser parser = new CsvParser(setting);
		List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
		System.out.println("------------------------------------------------");

		List<List<String>> matrix = new ArrayList<List<String>>();
		for (Record record : parseAllRecords) {
			System.out.println(record);
			String code = record.getValue(1, String.class);
			List<String> row = new ArrayList<String>();
			switch (code) {
			case "PD":
//				row = getDataForPD(code, record);

				String check2 = record.getValue(2, String.class);
				String check3 = record.getValue(3, String.class);
				String check4 = record.getValue(4, String.class);

				row.add(check2);
				row.add(check3);
				row.add(check4);

				System.out.println(row);

				System.out.println("PD check");
				break;
			case "AD":
//				row = getDataForAD(code, record);

				String checkk2 = record.getValue(2, String.class);
				String checkk3 = record.getValue(3, String.class);
				String checkk4 = record.getValue(4, String.class);

				row.add(checkk2);
				row.add(checkk3);
				row.add(checkk4);

				System.out.println(row);

				System.out.println("AD check");
				break;
			default:
				break;
			}
			matrix.add(row);
		}

		System.out.println("------------------------------------------------");

		System.out.println(matrix);

		return "Upload Successfull !!!";
	}
}
