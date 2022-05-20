package com.te.lms.ourenum;

public enum BloodGroup {
	O_NEGATIVE("O_NEGTIVE"), O_POSITIVE("O_POSITIVE"), A_NEGATIVE("A_NEGATIVE"), B_NEGATIVE("B_NEGATIVE"),
	B_POSITIVE("B_POSITIVE"), AB_NEGATIVE("AB_NEGATIVE");

	private final String empBloodGroup;
	
	BloodGroup(String bloodGroup) {
	this.empBloodGroup=bloodGroup;
	}
	public String getBloodGroup() {
		return empBloodGroup;
	}
}