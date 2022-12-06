package com.te.lms.dto;

import java.time.LocalDate;

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
public class ExperienceDto {

	private String companyName;

	private Integer yearsOfExperience;

	private LocalDate dateOfJoining;

	private LocalDate dateOfRelieving;

	private String designation;

	private String location;
}
