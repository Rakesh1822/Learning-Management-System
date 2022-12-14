package com.te.lms.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.google.common.collect.Lists;
import com.te.lms.enums.BatchStatus;
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
public class Batch {

	@Id
	private String batchId;

	private String batchName;

	@ManyToOne
	@JoinColumn(name = "mentor_fk")
	private Mentor mentor;

	@ManyToMany(mappedBy = "batch", cascade = CascadeType.ALL)
	private List<Technologies> technologies = Lists.newArrayList();

	private LocalDate startDate;

	private LocalDate endDate;

	@Enumerated(EnumType.STRING)
	private BatchStatus batchStatus;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "batch")
	private List<Employee> employee;

}
