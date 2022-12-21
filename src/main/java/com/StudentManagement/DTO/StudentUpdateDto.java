package com.StudentManagement.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentUpdateDto {
	
	@Email(message="Please enter a valid Email Address")
	private String email;
	
	 @NotNull @Pattern(regexp = "[0-9]{10}",message = "Mobile number should be of 10 digits")
	private String mobile_Number;
	 
	 @NotBlank @NotBlank @NotEmpty @Size(min = 3, max = 20,message = "Name must contain at least 3 characters")
	private String father_Name;
	 @NotBlank @NotBlank @NotEmpty @Size(min = 3, max = 20,message = "Name must contain at least 3 characters")
	private String mother_Name;

}
