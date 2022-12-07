package com.te.lms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.communication.Notify;
import com.te.lms.dto.MentorDto;
import com.te.lms.dto.NewBatchDto;
import com.te.lms.dto.RequestsListsDto;
import com.te.lms.dto.UpdateBatchDto;
import com.te.lms.dto.UpdateMentorDto;
import com.te.lms.entity.RequestsList;
import com.te.lms.exceptions.BatchDetailsNotUpdatedException;
import com.te.lms.exceptions.UnableToDeleteBatchException;
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

	@GetMapping(path = "/requestlist")
	public ResponseEntity<List<RequestsListsDto>> getRequestList() {
		List<RequestsListsDto> optEmployees = adminService.getRequestList();
		if (optEmployees != null) {
			return ResponseEntity.ok(optEmployees);
		}
		throw new RuntimeException("List is Empty");

	}

	@PutMapping(path = "/mentor/update/{empId}")
	public GeneralResponse<String> updateMentor(@PathVariable(name = "empId") String empId,
			@RequestBody UpdateMentorDto updateMentorDto) {
		Boolean isUpdated = adminService.updateMentor(empId, updateMentorDto);
		if (isUpdated) {
			return new GeneralResponse<String>("mentor has been updated", updateMentorDto.getMentorName());
		}
		throw new RuntimeException("update failed");
	}

	@PutMapping(path = "/mentor/delete/{empId}")
	public GeneralResponse<String> deleteMentor(@PathVariable(name = "empId") String empId) {
		Boolean isRemoved = adminService.deleteMentor(empId);
		if (isRemoved) {
			return new GeneralResponse<String>("Mentor has been removed", empId);
		}
		throw new RuntimeException("unable to delete the mentor");
	}

	@PutMapping(path = "/batch/delete/{batchId}")
	public GeneralResponse<String> deleteBatch(@PathVariable(name = "batchId") String batchId) {
		Boolean isRemoved = adminService.deleteBatch(batchId);
		if (isRemoved) {
			return new GeneralResponse<String>("batch has been deleted successfully", batchId);
		}
		throw new UnableToDeleteBatchException("unable to delete the batch");
	}

	@PutMapping(path = "/batch/update/{batchId}")
	public GeneralResponse<String> updateBatch(@PathVariable(name = "batchId") String batchId,
			@RequestBody UpdateBatchDto updateBatchDto) {
		Boolean isUpdated = adminService.updateBatch(batchId, updateBatchDto);
		if (isUpdated) {
			return new GeneralResponse<String>("batch details has been  updated", batchId);
		}
		throw new BatchDetailsNotUpdatedException("unable to update batch details");

	}

}
