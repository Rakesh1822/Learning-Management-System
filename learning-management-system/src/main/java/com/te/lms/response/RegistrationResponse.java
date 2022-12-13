package com.te.lms.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponse<T> {

	private String message;
	

	public RegistrationResponse(String message) {
		this.message = message;
	}

}
