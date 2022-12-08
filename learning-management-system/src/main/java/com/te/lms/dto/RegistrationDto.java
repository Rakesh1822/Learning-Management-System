package com.te.lms.dto;

import java.time.LocalDate;
import java.util.List;

import com.te.lms.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class RegistrationDto {

	private String employeeId;

	private String employeeName;

	private LocalDate employeeDOJ;

	private LocalDate employeeDOB;

	private String employeeEmailId;

	private String bloodGroup;

	private String employeeDesignation;

	private Gender employeeGender;

	private String employeeNationality;

	private SecondaryInfoDto secondaryInfoDto;

	private List<EducationDetailsDto> educationDetailsDto;

	private List<AddressDetailsDto> addressDetailsDto;

	private BankDetailsDto bankDetailsDto;

	private List<TechnicalSkillsDto> technicalSkillsDto;

	private List<ExperienceDto> experienceDto;

	private List<ContactDto> contactDto;
}
