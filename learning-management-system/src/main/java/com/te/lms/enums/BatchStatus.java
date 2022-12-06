package com.te.lms.enums;

public enum BatchStatus {

	INPROGRESS("IN-PROGRESS"), COMPLETED("COMPLETED"), TOBESTARTED("TO-BE-STARTED");

	private final String status;

	private BatchStatus(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}