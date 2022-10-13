package com.example.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
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
