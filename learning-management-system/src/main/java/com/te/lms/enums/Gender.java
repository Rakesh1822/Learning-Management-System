package com.te.lms.enums;

public enum Gender {

	MALE("MALE"), FEMALE("FEMALE"), OTHERS("OTHERS");

	private final String genderType;

	private Gender(String genderType) {
		this.genderType = genderType;
	}

	public String getGenderType() {
		return genderType;
	}

}
