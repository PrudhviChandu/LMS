package com.te.lms.ourenum;

public enum MockPanel {
	SRUTHI("SRUTHI"),VEENAL("VEENAL"),SWATHI("SWATHI"),AJAY("AJAY"),VIJENDRA("VIJENDRA");

	private final String batchPanel;

	private MockPanel(String batchPanel) {
		this.batchPanel = batchPanel;
	}

	public String getBatchPanel() {
		return batchPanel;
	}

	
}