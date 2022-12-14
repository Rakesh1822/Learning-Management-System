package com.te.lms.service.implementation;

import java.util.List;

import com.te.lms.entity.AddressDetails;
import com.te.lms.entity.Contact;
import com.te.lms.entity.EducationDetails;
import com.te.lms.entity.Employee;
import com.te.lms.entity.Experience;
import com.te.lms.entity.TechnicalSkills;

public class SetProperties {

//	public void setEmployee(List<T> properties, Employee employee) {
//
//		for (T t1 : properties) {
//              
//		}
//	}

	public static void setEducationDetailsToEmployee(List<EducationDetails> educationDetails, Employee employee) {
		for (EducationDetails educationDetails2 : educationDetails) {
			educationDetails2.setEmployee(employee);
		}
	}

	public static void setAddressDetailsToEmployee(List<AddressDetails> addressDetails, Employee employee) {
		for (AddressDetails addressDetails2 : addressDetails) {
			addressDetails2.setEmployee(employee);
		}
	}

	public static void setExperienceToEmployee(List<Experience> experience, Employee employee) {
		for (Experience experience2 : experience) {
			experience2.setEmployee(employee);
		}
	}

	public static void setContactToEmployee(List<Contact> contact, Employee employee) {
		for (Contact contact2 : contact) {
			contact2.setEmployee(employee);
		}
	}

	public static void setTechnicalSkillsToEmployee(List<TechnicalSkills> technicalSkills, Employee employee) {
		for (TechnicalSkills technicalSkills2 : technicalSkills) {
			technicalSkills2.setEmployee(employee);
		}
	}

}
