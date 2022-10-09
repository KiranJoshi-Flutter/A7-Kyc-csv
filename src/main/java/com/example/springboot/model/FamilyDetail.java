package com.example.springboot.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class FamilyDetail {

	// type = Grand Father, Father Name, Mother Name
	private String type;

	private String firstNameEng;
	private String middleNameEng;
	private String lastNameEng;

	private String firstNameNep;
	private String middleNameNep;
	private String lastNameNep;

}
