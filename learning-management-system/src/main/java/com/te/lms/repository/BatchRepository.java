package com.te.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.te.lms.entity.Batch;

public interface BatchRepository extends JpaRepository<Batch, String> {

	@Query(value = "select * from batch where status='ACTIVE'",nativeQuery = true)
	Optional<List<Batch>> getBatches();

}
