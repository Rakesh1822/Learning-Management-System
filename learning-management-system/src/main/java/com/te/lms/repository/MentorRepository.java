package com.te.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, String> {

	@Query(value = "select * from mentor where mentor_name=?1", nativeQuery = true)
	Optional<Mentor> findByMentorName(String mentorName);

	Optional<Mentor> findByEmployeeId(String empId);

	@Query(value = "select * from mentor where mentor_status='ACTIVE'",nativeQuery = true)
	Optional<List<Mentor>> getMentors();

	


}
