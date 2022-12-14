package com.te.lms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

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
@Entity
public class RequestsList {

    @Id
	private String employeeId;

	private String employeeName;

	private Integer employeeYOP;

	private Double employeePercentage;

	
	private Integer employeeExperience;

	private Long contactNumber;


}
