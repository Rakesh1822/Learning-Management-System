package com.te.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.entity.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}
