package com.StudentManagement.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagement.DTO.CourseDto;
import com.StudentManagement.DTO.StudentAddressDto;
import com.StudentManagement.DTO.StudentDto;
import com.StudentManagement.DTO.StudentOutputDto;
import com.StudentManagement.DTO.StudentUpdateDto;
import com.StudentManagement.Service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/")
	public ResponseEntity<StudentOutputDto> registerStudent(@Valid @RequestBody StudentDto studentDto)
	{
		StudentOutputDto student =studentService.registerStudent(studentDto);
		return new ResponseEntity<StudentOutputDto>(student,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<StudentOutputDto> updateStudentDetails(@Valid @RequestParam Integer studentId,@RequestParam String dob, @RequestBody StudentUpdateDto studentUpdateDto)
	{
		StudentOutputDto student =studentService.updateStudentDetails(studentUpdateDto, studentId, dob);
		return new ResponseEntity<StudentOutputDto>(student,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/{studentName}")
	public ResponseEntity<List<StudentDto>> getStudentsByName(@Valid @PathVariable String studentName)
	{
		List<StudentDto> list =studentService.getStudentsByName(studentName);
		return new ResponseEntity<List<StudentDto>>(list,HttpStatus.OK);
	}
	
	
	@GetMapping("/course")
	public ResponseEntity<Set<CourseDto>> getCoursesAssigned(@Valid @RequestParam Integer studentId,@RequestParam String dob)
	{
		Set<CourseDto> list =studentService.getCourseAssigned(studentId, dob);
		return new ResponseEntity<Set<CourseDto>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/topics")
	public ResponseEntity<List<String>> getAllTopicsAssigned(@Valid @RequestParam Integer studentId,@RequestParam String dob)
	{
		List<String> list=studentService.getAllTopicsAssigned(studentId, dob);
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/course/remove/{courseId}")
	public ResponseEntity<StudentOutputDto> leaveCourseById(@Valid @PathVariable Integer courseId,@RequestParam Integer studentId,@RequestParam String dob )
	{
		StudentOutputDto student =studentService.leaveCourseById(courseId, studentId, dob);
		return new ResponseEntity<StudentOutputDto>(student,HttpStatus.OK);
	}
	
	

}
