package com.example.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data
@Getter
@Setter
@NoArgsConstructor
public class FamilyDetail {

	// type = Grand Father, Father Name, Mother Name
	private String type;

	private PersonDetail personDetail = new PersonDetail();

//	void setPersonDetail(PersonDetail personDetail) {
//		this.personDetail = personDetail;
//	}

}
