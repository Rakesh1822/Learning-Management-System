package com.te.lms.dto;

import com.te.lms.enums.AccountType;
import com.te.lms.enums.ContactType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BankDetailsDto {

	private String accountNo;

	private String bankName;

	private AccountType accountType;

	private String ifscCode;

	private String branch;

	private String state;
}
