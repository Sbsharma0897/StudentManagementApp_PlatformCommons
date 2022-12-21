package com.StudentManagement.DTO;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.StudentManagement.Model.AddressType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAddressDto {
	
	@NotBlank @NotNull
	private String houseNumber;
	@NotBlank @NotNull
	private String StreetName;
	@NotBlank @NotNull
	private String area;
	
	private String state;
	@NotBlank @NotNull
	private String district;
	@NotBlank @NotNull
	private Integer pincode;
	
	@Enumerated(EnumType.STRING)
	private AddressType addressType;

}
