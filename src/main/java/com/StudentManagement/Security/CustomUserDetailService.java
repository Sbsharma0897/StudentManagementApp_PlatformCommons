package com.StudentManagement.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.StudentManagement.Model.Admin;
import com.StudentManagement.Repository.AdminRepo;



@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private AdminRepo adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<Admin> optional=adminRepo.findByLoginName(username);
		if(!optional.isPresent())
		{
			throw new UsernameNotFoundException("Admin with given login Name not found");
		}
		Admin admin=optional.get();
;
		return admin;
		
	}

}
