//package com.example.ejemplos_video.entities;
//
//import java.util.Set;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="university")
//public class University {
//	
//	//Entidad propietaria, en este caso el mapeo es bidireccional
//	//Si fuese unidireccional se deberia mapear solo de este lado y no del muchos
//	@OneToMany(mappedBy = "university", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<Student> students;
//	
//	public University () {}
//
//	public Set<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(Set<Student> students) {
//		this.students = students;
//	}
//
//	public University(Set<Student> students) {
//		super();
//		this.students = students;
//	}
//	
//	
//
//	
//}
