package com.te.lms.service;

import java.util.List;
import java.util.Optional;

import com.te.lms.dto.MentorDto;
import com.te.lms.dto.NewBatchDto;
import com.te.lms.dto.RequestsListsDto;
import com.te.lms.dto.UpdateBatchDto;
import com.te.lms.dto.UpdateMentorDto;

public interface AdminService {

	Optional<String> registerMentor(MentorDto mentorDto);

	Optional<String> createBatch(NewBatchDto newBatchDto);

	List<RequestsListsDto> getRequestList();

	Boolean updateMentor(String empId, UpdateMentorDto updateMentorDto);

	Boolean deleteMentor(String empId);

	Boolean deleteBatch(String batchId);

	Boolean updateBatch(String batchId, UpdateBatchDto updateBatchDto);

}
