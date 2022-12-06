package com.te.lms.enums;

public enum EmployeeStatus {

	ACTIVE("ACTIVE"), TERMINATED("TERMINATED"), ABSCONDED("ABSCONDED");

	private final String employeeStatus;

	private EmployeeStatus(String employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public String getEmployeeStatus() {
		return employeeStatus;
	}

}
