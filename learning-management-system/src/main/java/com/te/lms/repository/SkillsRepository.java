package com.te.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.te.lms.entity.Mentor;
import com.te.lms.entity.Skills;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {

	List<Skills> findByMentor(Mentor mentor);

}
