package com.te.lms.response;

import java.time.LocalDateTime;
import java.util.List;

import com.te.lms.entity.RequestsList;

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
	
	public GeneralResponse(String message, List<T> data) {
		this.message=message;
		this.data=getData();
	}

	

}
