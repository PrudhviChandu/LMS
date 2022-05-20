package com.te.lms.ourenum;

public enum ContactType {

	PERSONAL("PERSONAL"),WHATSAPP("WHATSAPP"),HOME("HOME"),SPOUSE("SPOUSE"),FRIEND("FRIEND");
	
	private final String contactType;

	ContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactType() {
		return contactType;
	}
}
