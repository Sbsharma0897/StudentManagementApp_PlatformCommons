package com.StudentManagement.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.DTO.CourseDto;
import com.StudentManagement.DTO.StudentAddressDto;
import com.StudentManagement.DTO.StudentCoursesDto;
import com.StudentManagement.DTO.StudentDto;
import com.StudentManagement.Exception.CourseException;
import com.StudentManagement.Exception.EnumException;
import com.StudentManagement.Exception.InvalidCredentialException;
import com.StudentManagement.Exception.StudentException;
import com.StudentManagement.Model.Course;
import com.StudentManagement.Model.CourseTypeEnum;
import com.StudentManagement.Model.Student;
import com.StudentManagement.Repository.CourseRepo;
import com.StudentManagement.Repository.StudentRepo;

import net.bytebuddy.asm.Advice.This;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private CourseRepo courseRepo;
	
	@Autowired 
	private ModelMapper modelMapper;
	

	@Override
	public CourseDto addCourse(CourseDto courseDto) {
		
		Course course=this.modelMapper.map(courseDto, Course.class);
		
		Course returnedCourse=null;
		if(courseDto.getCourseType().equals(CourseTypeEnum.FULLTIME) ||courseDto.getCourseType().equals(CourseTypeEnum.PARTTIME))
		{
			 returnedCourse=courseRepo.save(course);
		}
		else
		{
			throw new EnumException("Course Type is not defined accurately");
		}
		
		return this.modelMapper.map(returnedCourse, CourseDto.class);
	}
	
	@Override
	public StudentCoursesDto addCourseToStudent(Integer student_code, Integer course_Id) {
		
		Course course=courseRepo.findById(course_Id).orElseThrow(()->new CourseException("Course with given course Id does not exist"));
	    
		Student student=studentRepo.findById(student_code).orElseThrow(()->new StudentException("Student with given Id does not exist"));
	
		course.getStudents().add(student);
		student.getCourses().add(course);
		
		
		StudentCoursesDto studentCoursesDto=this.modelMapper.map(studentRepo.save(student),StudentCoursesDto.class);
		
		List<StudentAddressDto> addressDtos=student
				.getAddresses()
				.stream()
				.map(address->this.modelMapper.map(address,StudentAddressDto.class))
				.collect(Collectors.toList());
		
		Set<CourseDto> courseDtos=student
				.getCourses()
				.stream()
				.map(courseL->this.modelMapper.map(courseL,CourseDto.class))
				.collect(Collectors.toSet());
		
		studentCoursesDto.setCourses(courseDtos);
		
		return studentCoursesDto;
			
	}

	@Override
	public Set<StudentDto> getStudentsByCourseId(Integer courseId) {
		
		 Course course=courseRepo.findById(courseId).orElseThrow(()->new CourseException("Course with given course Id does not exist"));

		 Set<Student> list=course.getStudents();
		 
		 Set<StudentDto> ans=list.stream()
				 .map(student->this.modelMapper.map(student, StudentDto.class))
				 .collect(Collectors.toSet());
		 
		 if(ans.size()==0)
			{
				throw new StudentException("No students assigned to the given course");
			}
		 return ans;
		
	}
	
	@Override
	public CourseDto removeCourseById(Integer courseId) {
		
		Course course=courseRepo.findById(courseId).orElseThrow(()->new CourseException("Course with given course Id does not exist"));
	
		Set<Student> studentList=course.getStudents();
		for(Student student:studentList)
		{
			student.getCourses().remove(course);
			studentRepo.save(student);
		}
		course.setStudents(null);
		courseRepo.delete(course);
		
		CourseDto courseDto=new CourseDto();
	    courseDto.setCourseName(course.getCourseName());
		courseDto.setCourseType(course.getCourseType());
		courseDto.setDescription(course.getDescription());
		courseDto.setDuration(course.getDuration());
		
	    return courseDto;
	}
	
	@Override
	public Set<CourseDto> findCourseByName(String courseName) 
	{
		
		Set<Course> courseList=courseRepo.findByCourseName(courseName);
			
		Set<CourseDto> courseDtoList=courseList.stream()
				.map(course->this.modelMapper.map(course, CourseDto.class))
				.collect(Collectors.toSet());
					
			if(courseDtoList.size()==0)
			{
				throw new CourseException("No course found with given course name");
			}
		 return courseDtoList;
	}
	
	@Override
	public List<CourseDto> getCoursesByTopic(String topicName) {
	
		List<Course> courses=courseRepo.findAll();
		
		List<CourseDto> courseDtoList=courses.stream()
				.filter(course->course.getTopics().contains(topicName))
				.map(course->this.modelMapper.map(course, CourseDto.class))
				.collect(Collectors.toList());
					
			if(courseDtoList.size()==0)
			{
				throw new CourseException("No course found with given course name");
			}
		 return courseDtoList;
		
		
	}

	

}
