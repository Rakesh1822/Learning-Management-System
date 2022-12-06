package com.te.lms.enums;

public enum SkillRating {

	BEGINNER("BEGINNER"), INTERMEDIATE("INTERMEDIATE"), ADVANCED("ADVANCED"), EXPERT("EXPERT");

	private final String skillRating;

	private SkillRating(String skillRating) {
		this.skillRating = skillRating;
	}

	public String getSkillRating() {
		return skillRating;
	}

}
