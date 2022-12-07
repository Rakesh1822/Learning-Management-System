package com.te.lms.exceptions.handler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.google.common.collect.Maps;
import com.te.lms.exceptions.BatchDetailsNotUpdatedException;
import com.te.lms.exceptions.UnableToDeleteBatchException;

@RestControllerAdvice
public class LmsExceptionHandler {

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BatchDetailsNotUpdatedException.class)
	public Map<String, String> handler(BatchDetailsNotUpdatedException ex) {
		Map<String, String> map = Maps.newHashMap();
		map.put("error", ex.getMessage());
		return map;
	}

	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UnableToDeleteBatchException.class)
	public Map<String, String> handler(UnableToDeleteBatchException ex) {
		Map<String, String> map = Maps.newHashMap();
		map.put("error", ex.getMessage());
		return map;
	}
}
