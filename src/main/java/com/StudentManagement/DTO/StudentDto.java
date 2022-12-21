package com.StudentManagement.DTO;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;



import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.StudentManagement.Model.StudentAddress;
import com.StudentManagement.Model.AddressType;

import com.StudentManagement.Model.Gender;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
	
	
	
	@Size(min = 3, max = 20,message = "Name must contain at least 3 characters")
	private String name;
	
    private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Email(message="Please enter a valid Email Address")
	private String email;
	
	@Pattern(regexp = "[0-9]{10}",message = "Mobile number should be of 10 digits")
	private String mobile_Number;
	 
	@Size(min = 3, max = 20,message = "Name must contain at least 3 characters")
	private String father_Name;
	@Size(min = 3, max = 20,message = "Name must contain at least 3 characters")
	private String mother_Name;
	
	
	private List<StudentAddressDto> addresses=new ArrayList<>();


}
