package com.te.lms.enums;

public enum BatchStatus {

	INPROGRESS("IN-PROGRESS"), COMPLETED("COMPLETED"), TOBESTARTED("TO-BE-STARTED");

	private final String batchStatus;

	private BatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	public String getStatus() {
		return batchStatus;
	}

}
