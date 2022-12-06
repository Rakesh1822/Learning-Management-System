package com.te.lms.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.te.lms.dto.MentorDto;
import com.te.lms.dto.NewBatchDto;
import com.te.lms.dto.SkillsDto;
import com.te.lms.dto.TechnologiesDto;
import com.te.lms.entity.Batch;
import com.te.lms.entity.Mentor;
import com.te.lms.entity.Skills;
import com.te.lms.entity.Technologies;
import com.te.lms.repository.AdminRepository;
import com.te.lms.repository.BatchRepository;
import com.te.lms.repository.MentorRepository;
import com.te.lms.service.AdminService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {

	private final MentorRepository mentorRepository;
	private final AdminRepository adminRepository;
	private final BatchRepository batchRepository;

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

		mentorRepository.save(mentor);
		return Optional.ofNullable(mentor.getEmployeeId());

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

		batchRepository.save(batch);

		return Optional.ofNullable(newBatchDto.getBatchId());

	}
}
