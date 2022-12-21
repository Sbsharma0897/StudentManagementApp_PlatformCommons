package com.StudentManagement.Repository;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentManagement.Model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
	
 Optional<Student> findByStudentCode(Integer studentCode);
 
 List<Student> findByName(String name);
 

}
