package com.te.lms.enums;

public enum Experience {

	ONE(1),TWO(2),THREE(3),FOUR(4);
	
	private  final Integer yearsOfExperience;
	
	private Experience(Integer yearsOfExperience) {
		this.yearsOfExperience=yearsOfExperience;
	}

	public Integer getYearsOfExperience() {
		return yearsOfExperience;
	}
	
	
}
