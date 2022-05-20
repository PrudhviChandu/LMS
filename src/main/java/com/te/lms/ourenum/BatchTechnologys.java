package com.te.lms.ourenum;

public enum BatchTechnologys {

	REACT("REACT"),ANGULAR("ANGULAR"),JAVA_SPRINGBOOT("JAVA_SPRINGBOOT"),NODE_EXPRESS_JS("NODE_EXPRESS_JS");
	private final String batchTechnologys;
	private BatchTechnologys(String batchTechnologys) {
		this.batchTechnologys = batchTechnologys;
	}
	public String getBatchTechnologys() {
		return batchTechnologys;
	}
	 
	
}
