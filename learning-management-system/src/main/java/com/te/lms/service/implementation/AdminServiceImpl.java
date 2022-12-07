package com.te.lms.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.te.lms.dto.MentorDto;
import com.te.lms.dto.NewBatchDto;
import com.te.lms.dto.RequestsListsDto;
import com.te.lms.dto.SkillsDto;
import com.te.lms.dto.TechnologiesDto;
import com.te.lms.dto.UpdateBatchDto;
import com.te.lms.dto.UpdateMentorDto;
import com.te.lms.entity.AppUser;
import com.te.lms.entity.Batch;
import com.te.lms.entity.Mentor;
import com.te.lms.entity.RequestsList;
import com.te.lms.entity.Roles;
import com.te.lms.entity.Skills;
import com.te.lms.entity.Technologies;
import com.te.lms.enums.BatchStatus;
import com.te.lms.enums.EmployeeStatus;
import com.te.lms.repository.AppUserRepository;
import com.te.lms.repository.BatchRepository;
import com.te.lms.repository.MentorRepository;
import com.te.lms.repository.RequestsRepository;
import com.te.lms.repository.RolesRepository;
import com.te.lms.repository.TechnologiesRepository;
import com.te.lms.service.AdminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

	private final MentorRepository mentorRepository;
	private final BatchRepository batchRepository;
	private final RolesRepository rolesRepository;
	private final AppUserRepository appUserRepository;
	private final RequestsRepository requestsRepository;
	private final TechnologiesRepository technologiesRepository;

	@Override
	public Optional<String> registerMentor(MentorDto mentorDto) {

		Mentor mentor = new Mentor();
		BeanUtils.copyProperties(mentorDto, mentor);
		List<Skills> skills = Lists.newArrayList();
		for (SkillsDto skillsDto : mentorDto.getSkillsDto()) {
			Skills skillsEntity = new Skills();
			BeanUtils.copyProperties(skillsDto, skillsEntity);
			skills.add(skillsEntity);
			skillsEntity.setMentor(mentor);
		}
		mentor.setSkills(skills);
		Optional<Roles> optRole = rolesRepository.findByRoleName("ROLE_MENTOR");
		if (optRole.isPresent()) {
			AppUser appUser = AppUser.builder().username(mentor.getEmployeeId()).password("Welcome123")
					.roles(Lists.newArrayList()).build();
			appUser.getRoles().add(optRole.get());
			Roles role = Roles.builder().roleName("ROLE_MENTOR").appUser(Lists.newArrayList()).build();
			role.getAppUser().add(appUser);
			mentor.setMentorStatus(EmployeeStatus.ACTIVE);
			appUserRepository.save(appUser);
			mentorRepository.save(mentor);
			return Optional
					.ofNullable("username : " + appUser.getUsername() + "\n" + " password :" + appUser.getPassword());
		}
		return null;
	}

	@Override
	public Optional<String> createBatch(NewBatchDto newBatchDto) {
		Batch batch = new Batch();
		BeanUtils.copyProperties(newBatchDto, batch);
		List<Technologies> technologies = Lists.newArrayList();
		for (TechnologiesDto technologiesDto : newBatchDto.getTechnologiesDto()) {
			Technologies technologiesEntity = new Technologies();
			BeanUtils.copyProperties(technologiesDto, technologiesEntity);
			technologies.add(technologiesEntity);
			technologiesEntity.getBatch().add(batch);
		}
		batch.setTechnologies(technologies);

		Optional<Mentor> mentor = mentorRepository.findByMentorName(newBatchDto.getMentorName());
		if (mentor.isPresent()) {
			batch.setMentor(mentor.get());
			mentor.get().setBatch(batch);
		}

		batchRepository.save(batch);
		return Optional.ofNullable(newBatchDto.getBatchId());

	}

	@Override
	public List<RequestsListsDto> getRequestList() {
		Optional<List<RequestsList>> employees = Optional.ofNullable(requestsRepository.findAll());
		if (employees.isPresent()) {
			List<RequestsListsDto> requestListDto = Lists.newArrayList();

			for (RequestsList requestsLists : employees.get()) {
				RequestsListsDto requestsListsDto = new RequestsListsDto();
				BeanUtils.copyProperties(requestsLists, requestListDto);
				requestListDto.add(requestsListsDto);
			}
			return requestListDto;
		}

		return null;
	}

	@Override
	public Boolean updateMentor(String empId, UpdateMentorDto updateMentorDto) {
		Optional<Mentor> optMentor = mentorRepository.findById(empId);
		if (optMentor.isPresent()) {
			Mentor mentor = optMentor.get();
			BeanUtils.copyProperties(updateMentorDto, mentor);
			List<Skills> skills1 = mentor.getSkills();
			List<Skills> skills2 = Lists.newArrayList();

			for (SkillsDto skillsDto : updateMentorDto.getSkillsDto()) {
				Skills skillEntity = new Skills();
				BeanUtils.copyProperties(skillsDto, skillEntity);
				skills2.add(skillEntity);
			}
			for (int i = 0; i < skills2.size(); i++) {
				if (i < skills1.size()) {
					BeanUtils.copyProperties(skills2.get(i), skills1.get(i), new String[] { "sno", "mentor" });
				} else {
					skills1.add(skills2.get(i));
					skills2.get(i).setMentor(mentor);
				}
			}
			mentor.setSkills(skills1);
			mentorRepository.save(mentor);
			return true;
		}
		return false;
	}

	@Override
	public Boolean updateBatch(String batchId, UpdateBatchDto updateBatchDto) {

		Optional<Batch> optBatch = batchRepository.findById(batchId);
		if (optBatch.isPresent()) {
			Batch batch = optBatch.get();
			BeanUtils.copyProperties(updateBatchDto, batch);

			List<Technologies> technologies1 = batch.getTechnologies();
			technologiesRepository.deleteAll(technologies1);

			for (TechnologiesDto technologiesDto : updateBatchDto.getTechnologiesDto()) {
				Technologies technologies = new Technologies();
				BeanUtils.copyProperties(technologiesDto, technologies);
				technologies1.add(technologies);
				technologies.getBatch().add(batch);
			}
			batch.setTechnologies(technologies1);
			batchRepository.save(batch);
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteMentor(String empId) {
		Optional<Mentor> optMentor = mentorRepository.findById(empId);
		if (optMentor.isPresent()) {
			Mentor mentor = optMentor.get();
			mentor.setMentorStatus(EmployeeStatus.TERMINATED);
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteBatch(String batchId) {
		Optional<Batch> optBatch = batchRepository.findById(batchId);
		if (optBatch.isPresent()) {
			Batch batch = optBatch.get();
			batch.setBatchStatus(BatchStatus.COMPLETED);
			return true;
		}
		return false;
	}

}
