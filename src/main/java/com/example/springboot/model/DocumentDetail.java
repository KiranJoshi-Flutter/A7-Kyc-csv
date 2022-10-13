package com.example.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data

@Getter
@Setter

@NoArgsConstructor
public class DocumentDetail {

	private String boid;

	private String documentType;

	private String documentId;
	private String issuedDateBs;
	private String issuedDateAd;
	private String issuedFrom;
	private String fileId;
	private String backFielId;

}
