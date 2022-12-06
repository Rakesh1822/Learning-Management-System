package com.te.lms.dto;

import com.te.lms.enums.Experience;
import com.te.lms.enums.SkillRating;

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
public class TechnicalSkillsDto {

	private String skillType;

	private SkillRating skillRating;

	private Experience yearsOfExperience;
}
