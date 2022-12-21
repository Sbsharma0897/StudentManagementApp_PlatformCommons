package com.StudentManagement;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.StudentManagement.Model.Admin;
import com.StudentManagement.Repository.AdminRepo;

@SpringBootApplication
public class PlatformCommonsAssignmentApplication implements CommandLineRunner{
	
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(PlatformCommonsAssignmentApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		
		Admin admin1=new Admin();
		admin1.setAdmin_Id(1);
		admin1.setFullName("sandeep sharma");
		admin1.setPassword(passwordEncoder.encode("admin"));
		admin1.setLoginName("admin");
		
	    adminRepo.save(admin1);
		
   }
	
	


}
