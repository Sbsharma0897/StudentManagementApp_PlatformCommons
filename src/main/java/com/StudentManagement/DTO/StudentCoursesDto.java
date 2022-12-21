package com.StudentManagement.DTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.StudentManagement.Model.Course;
import com.StudentManagement.Model.Gender;
import com.StudentManagement.Model.StudentAddress;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StudentCoursesDto {
	
	
	private String name;
	
     private LocalDate dob;
	
	@Enumerated(EnumType.STRING) @NotNull
	private Gender gender;
	
	private String email;
	
	
	private String mobile_Number;
	 
	
	private String father_Name;

	private String mother_Name;
	
	
	private List<StudentAddressDto> addresses=new ArrayList<>();
	
	
	private Set<CourseDto> courses=new HashSet<>();


}
