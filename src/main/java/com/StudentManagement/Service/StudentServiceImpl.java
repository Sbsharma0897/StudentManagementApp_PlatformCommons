package com.StudentManagement.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.tomcat.jni.Address;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.DTO.CourseDto;
import com.StudentManagement.DTO.StudentAddressDto;
import com.StudentManagement.DTO.StudentDto;
import com.StudentManagement.DTO.StudentOutputDto;
import com.StudentManagement.DTO.StudentUpdateDto;
import com.StudentManagement.Exception.AddressException;
import com.StudentManagement.Exception.CourseException;
import com.StudentManagement.Exception.InvalidCredentialException;
import com.StudentManagement.Exception.StudentException;
import com.StudentManagement.Exception.UserAlreadyExistsException;
import com.StudentManagement.Model.Course;

import com.StudentManagement.Model.Student;
import com.StudentManagement.Model.StudentAddress;
import com.StudentManagement.Repository.AddressRepo;
import com.StudentManagement.Repository.CourseRepo;
import com.StudentManagement.Repository.StudentRepo;



@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired
	private CourseRepo courseRepo;

	
	@Autowired 
	private ModelMapper modelMapper;
	

	@Override
	public StudentOutputDto registerStudent(StudentDto studentDto) {
		
		Student student=this.modelMapper.map(studentDto, Student.class);
		
//		List<StudentAddress> listDtos=studentDto.getAddresses()
//				.stream()
//				.map(address->modelMapper.map(address, StudentAddress.class))
//				.collect(Collectors.toList());
//		
//		student.setAddresses(listDtos);
//		
		Student returnedStudent=null;
		try {
			returnedStudent=studentRepo.save(student);
		} catch (Exception e) {
			e.printStackTrace();
			throw new StudentException("Student with the given email id already exists");
		}
		
		return this.modelMapper.map(returnedStudent, StudentOutputDto.class);
	}
	@Override
	public StudentOutputDto updateStudentDetails(StudentUpdateDto studentUpdateDto, Integer studentId, String dob) {
		
		Student student=AuthenticateStudent(studentId, dob);
		
		student.setEmail(studentUpdateDto.getEmail());
		student.setFather_Name(studentUpdateDto.getFather_Name());
		student.setMobile_Number(studentUpdateDto.getMobile_Number());
		student.setMother_Name(studentUpdateDto.getMother_Name());
		
		Student returnedStudent=null;
		try {
			returnedStudent=studentRepo.save(student);
		} catch (Exception e) {
			throw new StudentException("Student with the given email id already exists");
		}
		
		return this.modelMapper.map(returnedStudent, StudentOutputDto.class);
	}
	
	@Override
	public List<StudentDto> getStudentsByName(String studentName) {
		
		List<Student> list=studentRepo.findByName(studentName);
		
		
		List<StudentDto> ans=list.stream().map(student->this.modelMapper.map(student, StudentDto.class))
				 .collect(Collectors.toList());
		
		if(ans.size()==0)
		{
			throw new StudentException("No students found with given name");
		}
		return ans;
	}
	
	
	@Override
	public StudentOutputDto leaveCourseById(Integer courseId, Integer studentId, String dob) {
		
		Student student=AuthenticateStudent(studentId, dob);
		
		Course course=courseRepo.findById(courseId).orElseThrow(()->new CourseException("Course with given course Id does not exist"));
	
		Set<Course> courses=student.getCourses();
		if(!courses.contains(course))
		{
		   throw new CourseException("Course with given course Id is not assigned to the student");
		}
	     
		student.getCourses().remove(course);
	    course.getStudents().remove(student);
	     
	     Student returnStudent=  studentRepo.save(student);
	     
	    return this.modelMapper.map(returnStudent, StudentOutputDto.class);
	}
	
	private Student AuthenticateStudent(Integer studentId,String dob)
	{
		Student student=studentRepo.findById(studentId).orElseThrow(()->new InvalidCredentialException("Student with given student Id does not exist"));
	    
		if(!(student.getDob().toString()).equals(dob))
		{
			System.out.println(dob);
			System.out.println(student.getDob().toString());
			throw new InvalidCredentialException("Date of birth entered is invalid");
		}
		
		
		return student;
	}

	@Override
	public Set<CourseDto> getCourseAssigned(Integer studentId,String dob)
	{
		
		Student student=AuthenticateStudent(studentId, dob);
       
		Set<Course> list=student.getCourses();
		
		Set<CourseDto> listCourseDtos=list.stream()
				.map(course->modelMapper.map(course, CourseDto.class))
				.collect(Collectors.toSet());
		
		if(listCourseDtos.size()==0)
		{
			throw new CourseException("No course assigned to the student");
		}
		
		return listCourseDtos;
	}
	@Override
	public List<String> getAllTopicsAssigned(Integer studentId, String dob) {
		
		Student student=AuthenticateStudent(studentId, dob);
		
		List<String> topics=new ArrayList<>();
		
		student.getCourses().stream().forEach(course-> topics.addAll(course.getTopics()));
		
		if(topics.size()==0)
		{
			throw new CourseException("Student has not been assigned any topics");
		}
		
		return topics;
		
	}
	

}
