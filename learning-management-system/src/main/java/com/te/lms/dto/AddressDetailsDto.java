package com.te.lms.dto;

import com.te.lms.enums.AddressType;
import com.te.lms.enums.ContactType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AddressDetailsDto {

	private AddressType addressType;

	private String doorNo;

	private String street;

	private String locality;

	private String city;

	private String state;

	private Integer pincode;

	private String landmark;
}
