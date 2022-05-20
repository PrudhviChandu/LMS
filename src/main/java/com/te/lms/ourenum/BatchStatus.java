package com.te.lms.ourenum;

public enum BatchStatus {
	STARTED("STARTED"), ONGOING("ONGOING"), PAUSED("PAUSED"), ENDED("ONGOING"), TERMINATED("TERMINATED");

	private final String batchStatus;

	BatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	public String getBatchStatus() {
		return batchStatus;
	}
}
