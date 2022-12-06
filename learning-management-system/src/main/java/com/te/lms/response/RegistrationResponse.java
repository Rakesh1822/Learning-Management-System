package com.te.lms.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationResponse<T> {

	private String message;
	private LocalDateTime localDateTime = LocalDateTime.now();

	public RegistrationResponse(String message) {
		this.message = message;
	}

}
