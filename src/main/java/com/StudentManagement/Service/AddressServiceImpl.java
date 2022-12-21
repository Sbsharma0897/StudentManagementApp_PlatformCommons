package com.StudentManagement.Service;

import java.time.LocalDate;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StudentManagement.DTO.StudentAddressDto;
import com.StudentManagement.DTO.StudentOutputDto;
import com.StudentManagement.Exception.AddressException;
import com.StudentManagement.Exception.InvalidCredentialException;
import com.StudentManagement.Model.Student;
import com.StudentManagement.Model.StudentAddress;
import com.StudentManagement.Repository.AddressRepo;
import com.StudentManagement.Repository.StudentRepo;


@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepo addressRepo;
	
	@Autowired 
	private ModelMapper modelMapper;
	
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public StudentOutputDto updateStudentAddress(StudentAddressDto studentAddressDto, Integer studentId, String dob) {
		
		Student student=AuthenticateStudent(studentId, dob);
		
		List<StudentAddress> addresses=student.getAddresses();
		StudentAddress studentAddressInput=this.modelMapper.map(studentAddressDto,StudentAddress.class);
		
		for(StudentAddress address:addresses)
		{
			if(address.getAddressType().equals(studentAddressDto.getAddressType()))
			{
				studentAddressInput.setAddressId(address.getAddressId());
				
			}
		}
		addressRepo.save(studentAddressInput);
		
		return this.modelMapper.map(student, StudentOutputDto.class);
		
	}
	@Override
	public StudentOutputDto addNewAddress(StudentAddressDto studentAddressDto, Integer studentId, String dob) {
		
        Student student=AuthenticateStudent(studentId, dob);
		
		List<StudentAddress> addresses=student.getAddresses();
		StudentAddress studentAddressInput=this.modelMapper.map(studentAddressDto,StudentAddress.class);
		
		for(StudentAddress address:addresses)
		{
			if(address.getAddressType().equals(studentAddressDto.getAddressType()))
			{
				throw new AddressException("Address of given type already exists");
				
			}
		}
		
		student.getAddresses().add(studentAddressInput);
		
		Student savedStudent=studentRepo.save(student);
		
		return this.modelMapper.map(savedStudent, StudentOutputDto.class);
	}
	
	private Student AuthenticateStudent(Integer studentId,String dob)
	{
		Student student=studentRepo.findById(studentId).orElseThrow(()->new InvalidCredentialException("Student with given student Id does not exist"));
	    
		if(!(student.getDob().toString()).equals(dob))
		{
			throw new InvalidCredentialException("Date of birth entered is invalid");
		}
		
		return student;
	}

}
