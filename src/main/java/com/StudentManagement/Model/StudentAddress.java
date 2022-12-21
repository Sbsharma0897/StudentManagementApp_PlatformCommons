package com.StudentManagement.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class StudentAddress {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer addressId;
	
//	@Override
//	public String toString() {
//		return "StudentAddress [addressId=" + addressId + ", houseNumber=" + houseNumber + ", StreetName=" + StreetName
//				+ ", area=" + area + ", state=" + state + ", district=" + district + ", pincode=" + pincode + "]";
//	}

	private String houseNumber;
	
	
	private String StreetName;
	
	private String area;
	
	private String state;
	
	private String district;
		
	private Integer pincode;
	
	@Enumerated(EnumType.STRING)
	private AddressType addressType;
	

	
	
	

}
