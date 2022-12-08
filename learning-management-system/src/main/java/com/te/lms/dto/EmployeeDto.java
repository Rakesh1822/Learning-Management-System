package com.te.lms.dto;

import java.time.LocalDate;
import java.util.List;

import com.google.common.collect.Lists;
import com.te.lms.enums.Gender;
import com.te.lms.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class EmployeeDto {

	private String employeeId;

	private String employeeName;

	private LocalDate employeeDOJ;

	private LocalDate employeeDOB;

	private String employeeEmailId;

	private String bloodGroup;

	private String employeeDesignation;

	private Gender employeeGender;

	private Status employeeStatus;

	private SecondaryInfoDto secondaryInfoDto;

	private List<EducationDetailsDto> educationDetailsDto=Lists.newArrayList();

	private List<AddressDetailsDto> addressDetailsDto=Lists.newArrayList();

	private BankDetailsDto bankDetailsDto;

	private List<TechnicalSkillsDto> technicalSkillsDto=Lists.newArrayList();

	private List<ExperienceDto> experienceDto=Lists.newArrayList();

	private List<ContactDto> contactDto = Lists.newArrayList();

}
