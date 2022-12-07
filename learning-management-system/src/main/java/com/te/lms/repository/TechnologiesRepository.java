package com.te.lms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.entity.Batch;
import com.te.lms.entity.Technologies;

public interface TechnologiesRepository extends JpaRepository<Technologies, Integer>{

	List<Technologies> findByBatch(Batch batch);

	
}
