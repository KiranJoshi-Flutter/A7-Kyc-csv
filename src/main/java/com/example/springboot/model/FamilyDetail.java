package com.example.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FamilyDetail {

	// type = Grand Father, Father Name, Mother Name
	private String type;

	private PersonDetail personDetail = new PersonDetail();

}
