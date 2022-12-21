package com.StudentManagement.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.StudentManagement.DTO.CourseDto;
import com.StudentManagement.DTO.StudentAddressDto;
import com.StudentManagement.DTO.StudentDto;
import com.StudentManagement.DTO.StudentOutputDto;
import com.StudentManagement.DTO.StudentUpdateDto;
import com.StudentManagement.Model.Course;
import com.StudentManagement.Model.Student;

import lombok.Setter;

public interface StudentService {

	StudentOutputDto registerStudent(StudentDto studentDto);
	
	StudentOutputDto updateStudentDetails(StudentUpdateDto studentUpdateDto,Integer studentId,String dob);
	
	List<StudentDto> getStudentsByName(String studentName);
	
	Set<CourseDto> getCourseAssigned(Integer studentId,String dob);
	
	List<String> getAllTopicsAssigned(Integer studentId,String dob);
	
	StudentOutputDto leaveCourseById(Integer courseId,Integer studentId,String dob);
	
	 
	
}
