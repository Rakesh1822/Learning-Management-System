package com.te.lms.response;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResponse<T> {

	private String message;
	private LocalDateTime timeStamp = LocalDateTime.now();
    private T data;
	

	public GeneralResponse(String message, T data) {
		this.message = message;
		this.data=data;
	}

}