package com.StudentManagement.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentManagement.Model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	Optional<Admin> findByLoginName(String loginName);

}
