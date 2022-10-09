package com.example.springboot.model;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class BankDetails {

	private String boid;

	private String accountType;
	private String bank;
	private String bankBranch;
	private String accountNo;
}
