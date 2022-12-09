package com.te.lms.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.common.collect.Lists;
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
public class Mentor {

	private String mentorName;

	@Id
	private String employeeId;

	private String emailId;

	@OneToMany(mappedBy = "mentor",cascade = CascadeType.ALL)
	private List<Skills> skills = Lists.newArrayList();

	@OneToMany(mappedBy = "mentor")
	private List<Batch> batch = Lists.newArrayList();

	@Enumerated(EnumType.STRING)
	private Status mentorStatus;

}
