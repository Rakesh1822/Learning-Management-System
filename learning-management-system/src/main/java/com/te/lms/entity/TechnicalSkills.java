package com.te.lms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.te.lms.enums.Experience;
import com.te.lms.enums.SkillRating;

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
@Table(name = "employee_technicalskills_info")
public class TechnicalSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer technicalId;
	
	private String skillType;
	
	@Enumerated(EnumType.STRING)
	private SkillRating skillRating;
	
	@Enumerated(EnumType.ORDINAL)
	private Experience yearsOfExperience;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_fk")
	private Employee employee;
}
