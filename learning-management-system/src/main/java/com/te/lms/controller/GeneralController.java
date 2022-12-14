package com.te.lms.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.RegistrationDto;
import com.te.lms.response.RegistrationResponse;
import com.te.lms.service.EmployeeService;
import com.te.lms.service.RequestsListService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/public")
public class GeneralController {

	private final EmployeeService employeeService;
	private final RequestsListService requestsListService;

	@PostMapping(path = "/employee/register")
	public RegistrationResponse<String> employeeRegistration(@RequestBody RegistrationDto registrationDto) {

		Optional<String> optionalUser = employeeService.register(registrationDto);
		if (optionalUser.isPresent()) {
			requestsListService.addToList(optionalUser.get());
		}
		return new RegistrationResponse("Your request will be approved in sometime please wait...........");

	}

}
