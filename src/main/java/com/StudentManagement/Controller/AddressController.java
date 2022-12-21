package com.StudentManagement.Controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.StudentManagement.DTO.StudentAddressDto;
import com.StudentManagement.DTO.StudentDto;
import com.StudentManagement.DTO.StudentOutputDto;
import com.StudentManagement.Service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	
	@PutMapping("/update")
	public ResponseEntity<StudentOutputDto> updateStudentAddress(@Valid @RequestParam Integer studentId,@RequestParam String dob,@RequestBody StudentAddressDto studentAddressDto)
	{
		StudentOutputDto student =addressService.updateStudentAddress(studentAddressDto, studentId, dob);
		return new ResponseEntity<StudentOutputDto>(student,HttpStatus.OK);
	}
		
	@PostMapping("/")
	public ResponseEntity<StudentOutputDto> addStudentAddress(@Valid @RequestParam Integer studentId,@RequestParam String dob, @RequestBody StudentAddressDto studentAddressDto)
	{
		StudentOutputDto student =addressService.addNewAddress(studentAddressDto, studentId, dob);
		return new ResponseEntity<StudentOutputDto>(student,HttpStatus.OK);
	}
	
	
}	