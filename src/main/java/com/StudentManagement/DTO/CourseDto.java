package com.StudentManagement.DTO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.StudentManagement.Model.CourseTypeEnum;
import com.StudentManagement.Model.Student;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
	
    @NotNull @NotBlank  @NotEmpty
	private String courseName;
    @NotNull @NotBlank  @NotEmpty
	private String description;
    
    @Enumerated(EnumType.STRING) 
	private CourseTypeEnum courseType;
    
    @NotNull
    @Min(value=1, message="minimum duration must be 1 month")
	private Integer duration;
	
	private List<String> topics=new ArrayList<>();
	



}
