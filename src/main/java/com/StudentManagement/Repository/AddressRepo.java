package com.StudentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.StudentManagement.Model.StudentAddress;

@Repository
public interface AddressRepo extends JpaRepository<StudentAddress, Integer>{


}
