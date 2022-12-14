package com.te.lms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
@Entity
@Table(name = "employee_primary_info")
public class Employee {

	@Id
	private String employeeId;

	private String employeeName;

	private LocalDate employeeDOJ;

	private LocalDate employeeDOB;

	private String employeeEmailId;

	private String bloodGroup;

	private String employeeDesignation;

	@Enumerated(EnumType.STRING)
	private Gender employeeGender;

	private String employeeNationality;

	@Enumerated(EnumType.STRING)
	private Status employeeStatus;

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private SecondaryInfo secondaryInfo;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<EducationDetails> educationDetails = Lists.newArrayList();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<AddressDetails> addressDetails = Lists.newArrayList();

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private BankDetails bankDetails;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<TechnicalSkills> technicalSkills = Lists.newArrayList();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Experience> experience = Lists.newArrayList();

	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private List<Contact> contact = Lists.newArrayList();

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Batch batch;

}
