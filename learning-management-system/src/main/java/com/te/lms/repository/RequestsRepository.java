package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.entity.RequestsList;

public interface RequestsRepository extends JpaRepository<RequestsList, Integer >{

}
