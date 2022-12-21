package com.StudentManagement.Service;

import java.util.List;
import java.util.Set;

import com.StudentManagement.DTO.CourseDto;
import com.StudentManagement.DTO.StudentCoursesDto;
import com.StudentManagement.DTO.StudentDto;
import com.StudentManagement.Model.Student;



public interface CourseService {
	
	CourseDto addCourse(CourseDto courseDto);
	
	StudentCoursesDto addCourseToStudent(Integer student_code,Integer course_Id);
	
	Set<StudentDto> getStudentsByCourseId(Integer courseId);
	
	CourseDto removeCourseById(Integer courseId);
	
	Set<CourseDto> findCourseByName(String courseName);
	
	List<CourseDto>  getCoursesByTopic(String topicName);
	
}
