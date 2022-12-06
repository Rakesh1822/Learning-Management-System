package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.te.lms.entity.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {

	@Query(value = "select * from mentor where mentor_name=?1", nativeQuery = true)
	Mentor findByMentorName(String mentorName);


}
