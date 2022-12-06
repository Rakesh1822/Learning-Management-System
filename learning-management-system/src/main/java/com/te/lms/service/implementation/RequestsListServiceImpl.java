package com.te.lms.service.implementation;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.te.lms.entity.Employee;
import com.te.lms.entity.RequestsList;
import com.te.lms.repository.EmployeeRepository;
import com.te.lms.repository.RequestsRepository;
import com.te.lms.service.RequestsListService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequestsListServiceImpl implements RequestsListService {

	private final EmployeeRepository employeeRepository;
	private final RequestsRepository requestsRepository;

	@Override
	public void addToList(String employeeId) {

		Optional<Employee> optEmployee = employeeRepository.findById(employeeId);

		if (optEmployee.isPresent()) {
			Employee employee = optEmployee.get();
			RequestsList requestsList = new RequestsList();
			requestsList.setEmployeeId(employee.getEmployeeId());
			requestsList.setEmployeeName(employee.getEmployeeName());
			requestsList.setEmployeePercentage(employee.getEducationDetails().get(0).getPercentage());
			requestsList.setEmployeeYOP(employee.getEducationDetails().get(0).getYearOfPassing().getYear());
			requestsList.setContactNumber(employee.getContact().get(0).getContactNumber());
			Optional<Integer> totalExperience = employeeRepository.getTotalExperiece(employeeId);
			requestsList.setEmployeeExperience(totalExperience.get());
			requestsRepository.save(requestsList);
		}
	}

}
