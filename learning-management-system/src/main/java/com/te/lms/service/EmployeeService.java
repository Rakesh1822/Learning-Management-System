package com.te.lms.service;

import java.util.Optional;

import com.te.lms.dto.RegistrationDto;
import com.te.lms.dto.SecondaryInfoDto;
import com.te.lms.dto.UpdateDto;

public interface EmployeeService {

	Optional<String> register(RegistrationDto registrationDto);

	

	Boolean update(String empId, UpdateDto updateDto);

}
