package com.example.springboot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BankDetail {

	private String boid;

	private String accountType;
	private String bank;
	private String bankBranch;
	private String accountNo;
}
