package com.example.springboot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BankDetails {

	private String boid;

	private String accountType;
	private String bank;
	private String bankBranch;
	private String accountNo;
}
