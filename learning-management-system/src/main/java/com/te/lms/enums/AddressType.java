package com.te.lms.enums;

public enum AddressType {

	PERMANENT("PERMANENT"), TEMPORARY("TEMPORARY");

	private String addressType;

	private AddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getAddressType() {
		return addressType;
	}

}
