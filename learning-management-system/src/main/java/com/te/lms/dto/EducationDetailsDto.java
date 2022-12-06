package com.te.lms.dto;

import java.time.LocalDate;

import com.te.lms.enums.EducationType;

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
public class EducationDetailsDto {

	
	private EducationType educationType;
	
	private LocalDate yearOfPassing;
	
	private Double percentage;
	
	private String universityName;
	
	private String instituteName;
	
	private String specialization;
	
	private String state;
}
