package com.StudentManagement.Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Course {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer courseId;
	
	
	private String courseName;
	
	private String description;
	
	@Enumerated(EnumType.STRING) 
	private CourseTypeEnum courseType;
	
	private Integer duration=0;
	
	@Embedded
	@ElementCollection
	private List<String> topics=new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL,mappedBy = "courses")
	private Set<Student> students=new HashSet<>();

	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName, courseType, description, duration);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(courseId, other.courseId) && Objects.equals(courseName, other.courseName)
				&& courseType == other.courseType && Objects.equals(description, other.description)
				&& Objects.equals(duration, other.duration);
	}
	
	
}
