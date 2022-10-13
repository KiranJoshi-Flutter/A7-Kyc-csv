package com.example.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data

@Getter
@Setter

@NoArgsConstructor
public class Biometrics {

	private String fingerPrintIsoLeft;
	private String fingerPrintIsoRight;
	private String leftFileId;
	private String rightFileId;
	private String signatureFileId;

}
