//package com.example.ejemplos_video.entities;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name="student")
//public class Student {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int id;
//	
//	@Column(name="nombre")
//	private String nombre;
//	
//	//no seria necesario si fuese unidireccional
//	@ManyToOne()
//	@JoinColumn(name = "university_id")
//	private University university;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public University getUniversity() {
//		return university;
//	}
//
//	public void setUniversity(University university) {
//		this.university = university;
//	}
//	
//	public Student() {
//	}
//
//	public Student(int id, String nombre, University university) {
//		super();
//		this.id = id;
//		this.nombre = nombre;
//		this.university = university;
//	}
//	
//	
//
//}
