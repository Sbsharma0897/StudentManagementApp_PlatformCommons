package com.StudentManagement.Service;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.StudentManagement.DTO.AdminDto;
import com.StudentManagement.Exception.UserAlreadyExistsException;
import com.StudentManagement.Model.Admin;
import com.StudentManagement.Repository.AdminRepo;



@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepo adminRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public AdminDto addAdmin(AdminDto adminDto) {
		
		
		Admin admin=modelMapper.map(adminDto,Admin.class);
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		Admin savedAdmin= null;
	    try {
			savedAdmin=adminRepo.save(admin);
		} catch (Exception e)
	    {
			throw new UserAlreadyExistsException("A user with same username already exists");
		}
	     
	     return modelMapper.map(savedAdmin,AdminDto.class);
	}

	
}
