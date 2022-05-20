package com.te.lms.ourenum;

public enum BatchPanel {
	SRUTHI("SRUTHI"),VEENAL("VEENAL"),SWATHI("SWATHI"),AJAY("AJAY"),VIJENDRA("VIJENDRA");

	private final String batchPanel;

	private BatchPanel(String batchPanel) {
		this.batchPanel = batchPanel;
	}

	public String getBatchPanel() {
		return batchPanel;
	}

	
}