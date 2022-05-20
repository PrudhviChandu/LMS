package com.te.lms.ourenum;

public enum MaritalStatus {
	SINGLE("SINGLE"), MARRIED("MARRIED"), WIDOWED("WIDOWED"), DIVORCED("DIVORCED");

	private final String maritalStatus;

	MaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getMaritalStatus() {
		return maritalStatus;

	}
}
