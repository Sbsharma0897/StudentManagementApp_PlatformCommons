package com.StudentManagement.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.StudentManagement.DTO.AdminDto;
import com.StudentManagement.Service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {
	

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/create")
	public ResponseEntity<AdminDto> addNewAdmin(@Valid @RequestBody AdminDto adminDto)
	{
		 AdminDto admin=adminService.addAdmin(adminDto);
		return new ResponseEntity<AdminDto>(admin,HttpStatus.CREATED);
	}
	
	

}
