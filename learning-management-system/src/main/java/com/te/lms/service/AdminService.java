package com.te.lms.service;

import java.util.List;
import java.util.Optional;

import com.te.lms.dto.ApproveDto;
import com.te.lms.dto.MentorDto;
import com.te.lms.dto.MessageDto;
import com.te.lms.dto.NewBatchDto;
import com.te.lms.dto.RejectDto;
import com.te.lms.dto.RequestsListsDto;
import com.te.lms.dto.UpdateBatchDto;
import com.te.lms.dto.UpdateMentorDto;

public interface AdminService {

	Optional<MessageDto> registerMentor(MentorDto mentorDto);

	Optional<String> createBatch(NewBatchDto newBatchDto);

	Optional<List<RequestsListsDto>> getRequestList();

	Boolean updateMentor(String empId, UpdateMentorDto updateMentorDto);

	Boolean deleteMentor(String empId);

	Boolean deleteBatch(String batchId);

	Boolean updateBatch(String batchId, UpdateBatchDto updateBatchDto);

	Optional<Object> getEmployee(String employeeId);

	Optional<List<MentorDto>> getMentors();

	Optional<List<NewBatchDto>> getBatchDetails();

	Optional<MessageDto> ApproveEmployee(String empId, ApproveDto approveDto);

	Optional<MessageDto> rejectEmployee(String empId, RejectDto rejectDto);

}
