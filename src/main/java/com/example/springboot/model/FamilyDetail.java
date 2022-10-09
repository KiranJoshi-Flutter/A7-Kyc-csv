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

	private PersonDetail personDetail = new PersonDetail();

}
