package com.StudentManagement.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer studentCode;
	
	
	private String name;
	
	private LocalDate dob;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(unique = true)
	private String email;
	
	
	private String mobile_Number;
	 
	
	private String father_Name;
	
	
	private String mother_Name;
	 
	@OneToMany(cascade = CascadeType.ALL,mappedBy="student")
	private List<StudentAddress> addresses=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Student_Course",
	           joinColumns = @JoinColumn(referencedColumnName = "studentCode",name = "student_Id"),
	           inverseJoinColumns = @JoinColumn(referencedColumnName = "courseId",name = "course_Id"))
	private Set<Course> courses=new HashSet<>();

	@Override
	public int hashCode() {
		return Objects.hash(dob, email, father_Name, gender, mobile_Number, mother_Name, name, studentCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(father_Name, other.father_Name) && gender == other.gender
				&& Objects.equals(mobile_Number, other.mobile_Number) && Objects.equals(mother_Name, other.mother_Name)
				&& Objects.equals(name, other.name) && Objects.equals(studentCode, other.studentCode);
	}

	
	
	
	

}
