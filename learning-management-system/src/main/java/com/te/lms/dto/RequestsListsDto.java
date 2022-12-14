package com.te.lms.dto;

import lombok.Setter;

import lombok.Getter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RequestsListsDto {

	private Integer Id;

	private String employeeId;

	private String employeeName;

	private Integer employeeYOP;

	private Double employeePercentage;

	private Integer employeeExperience;

	private Long contactNumber;

}
