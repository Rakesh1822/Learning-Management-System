package com.te.lms.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateDto {

	private String bloodGroup;

	private LocalDate employeeDOB;
	
	private String employeeNationality;
	
	private SecondaryInfoDto secondaryInfoDto;

	private List<EducationDetailsDto> educationDetailsDto;

	private List<AddressDetailsDto> addressDetailsDto;

	private BankDetailsDto bankDetailsDto;

	private List<TechnicalSkillsDto> technicalSkillsDto;

	private List<ExperienceDto> experienceDto;

	private List<ContactDto> contactDto;

}
