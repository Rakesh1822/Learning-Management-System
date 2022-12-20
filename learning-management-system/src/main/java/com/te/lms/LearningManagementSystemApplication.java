package com.te.lms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.google.common.collect.Lists;
import com.te.lms.entity.Admin;
import com.te.lms.entity.AppUser;
import com.te.lms.entity.Roles;
import com.te.lms.repository.AdminRepository;
import com.te.lms.repository.AppUserRepository;
import com.te.lms.repository.RolesRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SpringBootApplication
public class LearningManagementSystemApplication {

	private final RolesRepository rolesRepository;
	private final AppUserRepository appUserRepository;
	private final AdminRepository adminRepository;

	public static void main(String[] args) {
		SpringApplication.run(LearningManagementSystemApplication.class, args);
	}

	@Bean 
	public CommandLineRunner runner() {
		return args -> {

			Roles employee = Roles.builder().roleName("ROLE_EMPLOYEE").build();
			Roles mentor = Roles.builder().roleName("ROLE_MENTOR").build();
			Roles admin = Roles.builder().roleName("ROLE_ADMIN").appUser(Lists.newArrayList()).build();

			Admin admin01 = Admin.builder().adminId("TYC001").adminName("Rakesh Reddy").build();

			AppUser adminCredentials = AppUser.builder().username(admin01.getAdminId()).password("password")
					.roles(Lists.newArrayList()).build();

			admin.getAppUser().add(adminCredentials);
			adminCredentials.getRoles().add(admin);

			rolesRepository.save(employee);
			rolesRepository.save(mentor);
			rolesRepository.save(admin);
			adminRepository.save(admin01);

			appUserRepository.save(adminCredentials);

		};
	}

}
