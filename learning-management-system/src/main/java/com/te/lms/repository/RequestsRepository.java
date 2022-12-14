package com.te.lms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.te.lms.entity.RequestsList;

public interface RequestsRepository extends JpaRepository<RequestsList, String >{

	@Query(value = "select * from requests_list",nativeQuery = true)
	List<RequestsList> getList();


}
