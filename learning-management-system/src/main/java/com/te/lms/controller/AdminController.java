package com.te.lms.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.communication.Notify;
import com.te.lms.dto.MentorDto;
import com.te.lms.dto.NewBatchDto;
import com.te.lms.response.GeneralResponse;
import com.te.lms.service.AdminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/admin")
public class AdminController {

	private final AdminService adminService;
	private final Notify notify;

	@PostMapping(path = "/register/mentor")
	public GeneralResponse<String> registerMentor(@RequestBody MentorDto mentorDto) {

		Optional<String> optUser = adminService.registerMentor(mentorDto);
		if (optUser.isPresent()) {
			String message = "Hello " + mentorDto.getMentorName()
					+ " your role has been updated as an mentor Please use the credentials for the accessing the Mentor features. \n "
					+ optUser.get();
			String subject = "Congratulations";
			String emailId = mentorDto.getEmailId();
			notify.sendEmail(message, emailId, subject);
			return new GeneralResponse<String>("mentor has been registered successfully", optUser.get());
		}

		throw new RuntimeException("Unable to register the mentor");

	}

	@PostMapping(path = "/register/batch")
	public GeneralResponse<String> createBatch(@RequestBody NewBatchDto newBatchDto) {
		Optional<String> optBacthId = adminService.createBatch(newBatchDto);
		if (optBacthId.isPresent()) {
			return new GeneralResponse<String>("a Batch has been created", optBacthId.get());
		}
		throw new RuntimeException("unable to register the batch");

	}

}
