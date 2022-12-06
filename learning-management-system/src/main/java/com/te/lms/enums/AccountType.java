package com.te.lms.enums;

public enum AccountType {

	SAVINGS("SAVINGS"), CURRENT("CURRENT");

	private String accountType;

	private AccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountType() {
		return accountType;
	}

}
