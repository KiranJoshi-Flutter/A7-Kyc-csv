package com.example.springboot.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DocumentDetails {

	private String boid;

	private String documentType;
	private String documentId;
	private String issuedDateBs;
	private String issuedDateAd;
	private String issuedFrom;
	private String fileId;
	private String backFielId;

}
