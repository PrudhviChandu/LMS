package com.te.lms.ourenum;

public enum UserRoles {

	ROLE_ADMIN("ROLE_ADMIN"),ROLE_MENTOR("ROLE_MENTOR"),ROLE_EMPLOYEE("ROLE_EMPLOYEE");
	private final String userRoles;

	private UserRoles(String userRoles) {
		this.userRoles = userRoles;
	}

	public String getUserRoles() {
		return userRoles;
	}
	
	
}
