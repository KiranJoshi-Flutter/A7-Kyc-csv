package com.example.springboot.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Biometrics {

	private String fingerPrintIsoLeft;
	private String fingerPrintIsoRight;
	private String leftFileId;
	private String rightFileId;
	private String signatureFileId;

}
