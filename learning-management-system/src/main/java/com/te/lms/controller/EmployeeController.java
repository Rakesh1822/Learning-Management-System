package com.te.lms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.dto.SecondaryInfoDto;
import com.te.lms.dto.UpdateDto;
import com.te.lms.response.GeneralResponse;
import com.te.lms.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/auth")
public class EmployeeController {

	private final EmployeeService employeeService;


	@PutMapping(path = "/employee/update/{empId}")
	public GeneralResponse<String> update(@RequestBody UpdateDto updateDto,
			@PathVariable String empId) {
		Boolean isUpdated = employeeService.update(empId, updateDto);
		if (isUpdated) {
			return new GeneralResponse<String>("emplpoyeeDetails has been updated succesfully", empId);
		}
		throw new RuntimeException("unable to update the details");

	}

}
