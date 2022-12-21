package com.StudentManagement.Service;

import java.time.LocalDate;

import com.StudentManagement.DTO.StudentAddressDto;
import com.StudentManagement.DTO.StudentOutputDto;

public interface AddressService {
	
   StudentOutputDto updateStudentAddress(StudentAddressDto studentAddressDto,Integer studentId,String dob);
	
   StudentOutputDto addNewAddress(StudentAddressDto studentAddressDto,Integer studentId,String dob);
	
	

}
