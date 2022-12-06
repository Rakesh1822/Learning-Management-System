package com.te.lms.enums;

public enum ContactType {

	MOBILE("MOBILE"), HOME("HOME"), EMERGENCY("EMERGENCY");

	private final String contactType;

	private ContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getContactType() {
		return contactType;
	}

}
