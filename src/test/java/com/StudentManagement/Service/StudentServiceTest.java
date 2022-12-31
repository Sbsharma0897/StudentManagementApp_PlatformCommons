package com.StudentManagement.Service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.StudentManagement.DTO.StudentDto;
import com.StudentManagement.Model.Gender;
import com.StudentManagement.Model.Student;
import com.StudentManagement.Repository.StudentRepo;

@SpringBootTest
class StudentServiceTest {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private StudentRepo studentRepo;

	@BeforeEach
	void setUp() throws Exception
	{
		Student student=new Student();
		student.setEmail("saa@fsd.com");
		student.setFather_Name("dsdsd");
		student.setGender(Gender.FEMALE);
		student.setName("sandeep");
		student.setStudentCode(1);
		List<Student> list=new ArrayList<>();
		list.add(student);
		Mockito.when(studentRepo.findByName("sandeep")).thenReturn(list);
	}
	
	@Test
	public void  getStudentsByName()
	{
	    String studentName="sandeep";
	    List<StudentDto> list=studentService.getStudentsByName(studentName);
	    
	    assertEquals(1,list.size());
	}

	
}
