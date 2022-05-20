package com.te.lms.ourenum;

public enum AccountType {
	SAVINGS("SAVINGS"), FIXED_DEPOSIT("FIXED_DEPOSIT"), CURRENT_ACCOUNT("CURRENT_ACCOUNT"),
	RECURRING_DEPOSIT("RECURRING_DEPOSIT"), SALARY_ACCOUNT("SALARY_ACCOUNT");

	private final String accountType;

	AccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountType() {
		return accountType;

	}
}
