package com.te.lms.service.implementation;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.google.common.collect.Lists;
import com.te.lms.dto.AddressDetailsDto;
import com.te.lms.dto.BankDetailsDto;
import com.te.lms.dto.ContactDto;
import com.te.lms.dto.EducationDetailsDto;
import com.te.lms.dto.ExperienceDto;
import com.te.lms.dto.SecondaryInfoDto;
import com.te.lms.dto.TechnicalSkillsDto;
import com.te.lms.entity.AddressDetails;
import com.te.lms.entity.BankDetails;
import com.te.lms.entity.Contact;
import com.te.lms.entity.EducationDetails;
import com.te.lms.entity.Experience;
import com.te.lms.entity.SecondaryInfo;
import com.te.lms.entity.TechnicalSkills;

public class ConvertToEntity{

//	public List<T> convertToEntity(List<T> properties) {
//		List<T> t = Lists.newArrayList();
//		for (T t1 : properties) {
//			T t2=null;
//			BeanUtils.copyProperties(t1, t2);
//			t.add(t2);
//
//		}
//		return t;
//	}

	static SecondaryInfo toSecondaryInfo(SecondaryInfoDto secondaryInfoDto) {
		SecondaryInfo secondaryInfo = new SecondaryInfo();
		BeanUtils.copyProperties(secondaryInfoDto, secondaryInfo);
		return secondaryInfo;
	}

	static BankDetails toBankDetails(BankDetailsDto bankDetailsDto) {
		BankDetails bankDetails = new BankDetails();
		BeanUtils.copyProperties(bankDetailsDto, bankDetails);
		return bankDetails;
	}

	static List<EducationDetails> toEducationDetails(List<EducationDetailsDto> educationDetailsDto) {

		List<EducationDetails> educationDetails = Lists.newArrayList();
		for (EducationDetailsDto educationDetailsDto2 : educationDetailsDto) {
			EducationDetails educationDetailsEntity = new EducationDetails();
			BeanUtils.copyProperties(educationDetailsDto2, educationDetailsEntity);
			educationDetails.add(educationDetailsEntity);

		}
		return educationDetails;
	}

	static List<AddressDetails> toAddressDetails(List<AddressDetailsDto> addressDetailsDto) {
		List<AddressDetails> addressDetails = Lists.newArrayList();
		for (AddressDetailsDto addressDetailsDto2 : addressDetailsDto) {
			AddressDetails addressDetailsEntity = new AddressDetails();
			BeanUtils.copyProperties(addressDetailsDto2, addressDetailsEntity);
			addressDetails.add(addressDetailsEntity);
		}
		return addressDetails;

	}

	static List<Experience> toExperience(List<ExperienceDto> experienceDto) {
		List<Experience> experience = Lists.newArrayList();
		for (ExperienceDto experienceDto2 : experienceDto) {
			Experience experienceEntity = new Experience();
			BeanUtils.copyProperties(experienceDto2, experienceEntity);
			experience.add(experienceEntity);
		}
		return experience;
	}

	static List<Contact> toContact(List<ContactDto> contactDto) {
		List<Contact> contact = Lists.newArrayList();
		for (ContactDto contactDto2 : contactDto) {
			Contact contactEntity = new Contact();
			BeanUtils.copyProperties(contactDto2, contactEntity);
			contact.add(contactEntity);
		}
		return contact;
	}

	static List<TechnicalSkills> toTechnicalSkills(List<TechnicalSkillsDto> technicalSkillsDto) {
		List<TechnicalSkills> technicalSkills = Lists.newArrayList();
		for (TechnicalSkillsDto technicalSkillsDto2 : technicalSkillsDto) {
			TechnicalSkills technicalSkillsEntity = new TechnicalSkills();
			BeanUtils.copyProperties(technicalSkillsDto2, technicalSkillsEntity);
			technicalSkills.add(technicalSkillsEntity);
		}
		return technicalSkills;
	}

}
