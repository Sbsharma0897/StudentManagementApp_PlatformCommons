package com.StudentManagement.Controller;

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
import com.StudentManagement.DTO.StudentCoursesDto;
import com.StudentManagement.DTO.StudentDto;

import com.StudentManagement.Service.CourseService;


@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addCourse")
	public ResponseEntity<CourseDto> addCourse(@Valid @RequestBody CourseDto courseDto)
	{
		CourseDto course =courseService.addCourse(courseDto);
		return new ResponseEntity<CourseDto>(course,HttpStatus.CREATED);
	}
	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/addCourseToStudent")
	public ResponseEntity<StudentCoursesDto> addCourseToStudent(@Valid @RequestParam Integer student_code,@RequestParam Integer course_Id)
	{
		StudentCoursesDto studentCourse =courseService.addCourseToStudent(student_code, course_Id);
		return new ResponseEntity<StudentCoursesDto>(studentCourse,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/getByCourse/{courseId}")
	public ResponseEntity<Set<StudentDto>> getStudentsByCourseId(@Valid @PathVariable Integer courseId )
	{
		Set<StudentDto> set =courseService.getStudentsByCourseId(courseId);
		return new ResponseEntity<Set<StudentDto>>(set,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/delete/{courseId}")
	public ResponseEntity<CourseDto> removeCourseById(@Valid @PathVariable Integer courseId )
	{
		CourseDto courseDto =courseService.removeCourseById(courseId);
		return new ResponseEntity<CourseDto>(courseDto,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/course/{courseName}")
	public ResponseEntity<Set<CourseDto>> findCourseByName(@Valid @PathVariable String courseName)
	{
		Set<CourseDto> set =courseService.findCourseByName(courseName);
		return new ResponseEntity<Set<CourseDto>>(set,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/topic/{topic}")
	public ResponseEntity<List<CourseDto>> getCoursesByTopic(@Valid @PathVariable String topic )
	{
		List<CourseDto> list =courseService.getCoursesByTopic(topic);
		return new ResponseEntity<List<CourseDto>>(list,HttpStatus.OK);
	}
	
}
