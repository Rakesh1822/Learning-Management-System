package com.te.lms.response;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResponse<T> {

	private String message;
	private LocalDate timeStamp = LocalDate.now();
    private T data;
	

	public GeneralResponse(String message, T data) {
		this.message = message;
		this.data=data;
	}
	

	

}
