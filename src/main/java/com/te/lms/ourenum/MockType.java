package com.te.lms.ourenum;

public enum MockType {
	MOCK("MOCK"), REMOCK("REMOCK"), REMOCK_2("REMOCK_2"), FINAL_MOCK("FINAL_MOCK");

	private final String mockType;

	MockType(String mockType) {
		this.mockType = mockType;
	}

	public String getMockType() {
		return mockType;
	}
}
