package com.te.lms.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import com.te.lms.dto.MentorDto;
import com.te.lms.dto.MessageDto;
import com.te.lms.dto.SkillsDto;
import com.te.lms.dto.UpdateMentorDto;
import com.te.lms.response.GeneralResponse;
import com.te.lms.service.AdminService;

@SpringBootTest
@AutoConfigureMockMvc
public class TestAdminController {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AdminService adminService;

	@InjectMocks
	private AdminController adminController;

	@Autowired
	private ObjectMapper objectMapper;

	// test case for registering mentor successfully.......
	@Test
	public void testRegisterMentor() throws JsonProcessingException, UnsupportedEncodingException, Exception {
		List<SkillsDto> skillsDto = Lists.newArrayList();
		SkillsDto skillDto = new SkillsDto();
		skillDto.setSkillName("Java");
		skillsDto.add(skillDto);
		MentorDto mentorDto = MentorDto.builder().emailId("a@a.com").mentorName("Rakesh").employeeId("TY002")
				.skillsDto(skillsDto).build();
		MessageDto messageDto = MessageDto.builder().emaild("a@a.com").message("message").build();

		Mockito.when(adminService.registerMentor(Mockito.any())).thenReturn(Optional.ofNullable(messageDto));

		String contentAsString = mockMvc
				.perform(MockMvcRequestBuilders.post("/admin/register/mentor").accept(MediaType.APPLICATION_JSON_VALUE)
						.contentType(MediaType.APPLICATION_JSON_VALUE)
						.content(objectMapper.writeValueAsString(mentorDto)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		GeneralResponse<String> readValue = objectMapper.readValue(contentAsString, GeneralResponse.class);
		assertEquals("mentor has been registered successfully", readValue.getMessage());
	}

	// test case for register mentor which returns bad Http response as bad Request
	@Test
	public void testRegisterMentor_Returns400()
			throws JsonProcessingException, UnsupportedEncodingException, Exception {
		MentorDto mentorDto = MentorDto.builder().emailId("a@a.com").mentorName("Rakesh").employeeId("TY002")
				.skillsDto(Lists.newArrayList()).build();
		MessageDto messageDto = MessageDto.builder().emaild("a@a.com").message("message").build();

		Mockito.when(adminService.registerMentor(Mockito.any())).thenReturn(Optional.ofNullable(null));

		mockMvc.perform(MockMvcRequestBuilders.post("/admin/register/mentor").accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(mentorDto)))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	// TestCase to delete mentor
	@Test
	public void testDeleteMentor() throws Exception {

		MentorDto mentorDto = MentorDto.builder().emailId("a@a.com").employeeId("TY001").mentorName("Rakesh reddy")
				.skillsDto(Lists.newArrayList()).build();
		List<SkillsDto> skills = Lists.newArrayList();
		SkillsDto skillDto = new SkillsDto();
		skillDto.setSkillName("skill-1");
		skills.add(skillDto);
		mentorDto.setSkillsDto(skills);

		Mockito.when(adminService.deleteMentor(mentorDto.getEmployeeId())).thenReturn(true);

		mockMvc.perform(MockMvcRequestBuilders.put("/admin/mentor/delete/{empId}", "TY001")
				.contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(mentorDto)))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	// test case to delete mentor that return Error 400
	@Test
	public void testDeleteMentor_Returns400() throws Exception {
		MentorDto mentorDto = new MentorDto();
		Mockito.when(adminService.deleteMentor(mentorDto.getEmployeeId())).thenReturn(false);

		mockMvc.perform(MockMvcRequestBuilders.put("/admin/mentor/delete/{empId}", "TY001")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

	// test case to update mentor successfully.....
	@Test
	public void testUpdateMentor() throws Exception {
		UpdateMentorDto updateMentorDto = UpdateMentorDto.builder().emailId("a@a.com").mentorName("Rakesh Reddy")
				.skillsDto(Lists.newArrayList()).build();
		List<SkillsDto> skills = Lists.newArrayList();
		SkillsDto skillDto = new SkillsDto();
		skillDto.setSkillName("skill-1");
		skills.add(skillDto);
		updateMentorDto.setSkillsDto(skills);

		Mockito.when(adminService.updateMentor(Mockito.any(), Mockito.any())).thenReturn(true);

		String contentAsString = mockMvc
				.perform(MockMvcRequestBuilders.put("/admin/mentor/update/{empId}", "TY001")
						.accept(MediaType.APPLICATION_JSON_VALUE)
						.content(objectMapper.writeValueAsString(updateMentorDto))
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		GeneralResponse<String> readValue = objectMapper.readValue(contentAsString, GeneralResponse.class);
		assertEquals("mentor has been updated", readValue.getMessage());
	}

	// Test case for update mentor that returns Bad request status
	@Test
	public void testUpdateMentor_Returns400() throws Exception {

		UpdateMentorDto updateMentorDto = new UpdateMentorDto();

		Mockito.when(adminService.updateMentor(Mockito.any(), Mockito.any())).thenReturn(false);

		mockMvc.perform(MockMvcRequestBuilders.put("/admin/mentor/update/{empId}", "TY001")
				.accept(MediaType.APPLICATION_JSON_VALUE).content(objectMapper.writeValueAsString(updateMentorDto))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	// test case of delete batch
	@Test
	public void testDeleteBatch() throws Exception {
		String batchId = "Batch-01";
		Mockito.when(adminService.deleteBatch(batchId)).thenReturn(true);

		mockMvc.perform(MockMvcRequestBuilders.put("/admin/batch/delete/{empId}", "Batch-01")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk());

	}

	// test case for delete batch that return response as BAD REQUEST
	@Test
	public void testDeleteBatch_Returns400() throws Exception {
		String batchId = "Batch-01";

		Mockito.when(adminService.deleteBatch(batchId)).thenReturn(false);

		mockMvc.perform(MockMvcRequestBuilders.put("/admin/batch/delete/{empId}", "Batch-01")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest());

	}

}
