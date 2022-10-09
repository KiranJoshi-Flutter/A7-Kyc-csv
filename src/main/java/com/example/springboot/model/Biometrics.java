package com.example.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Biometrics {

	private String fingerPrintIsoLeft;
	private String fingerPrintIsoRight;
	private String leftFileId;
	private String rightFileId;
	private String signatureFileId;

}
