package com.StudentManagement.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDto {
	
	   @NotNull @NotBlank @NotEmpty
	   private String fullName;
	   
	   @NotNull @NotBlank @NotEmpty
	   private String loginName;
	   
	   @Pattern(regexp = "[A-Za-z0-9@]{6,15}",message = "Password must be 6 to 15 characters and must have at least 1 alphabate and 1 number")
	   @NotNull @NotBlank @NotEmpty
	   private String password;

}
