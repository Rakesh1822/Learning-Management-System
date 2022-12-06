package com.te.lms.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.te.lms.enums.Action;
import com.te.lms.enums.Experience;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;

import org.checkerframework.common.aliasing.qual.Unique;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class RequestsList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;

	@Unique
	private String employeeId;

	private String employeeName;

	private Integer employeeYOP;

	private Double employeePercentage;

	
	private Integer employeeExperience;

	private Long contactNumber;

	@Enumerated(EnumType.STRING)
	private Action action;

}
