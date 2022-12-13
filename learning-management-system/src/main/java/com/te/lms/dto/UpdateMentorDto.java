package com.te.lms.dto;

import java.util.List;

import com.google.common.collect.Lists;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UpdateMentorDto {

	private String mentorName;


	private String emailId;

	private List<SkillsDto> skillsDto = Lists.newArrayList();
}
