package com.example.ejemplos_video.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="avatar")
public class Avatar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String email;
	
	private String webPersonal;
	
	private String imagen;
	
	
	//Relación no propietaria
	@OneToOne(mappedBy = "avatar")
	@JsonIgnore
	private Persona persona;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebPersonal() {
		return webPersonal;
	}
	public void setWebPersonal(String webPersonal) {
		this.webPersonal = webPersonal;
	}
	public Avatar(int id, String email, String webPersonal) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
	}
	
	public Avatar() {
		super();
		
	}
	@Override
	public String toString() {
		return "Avatar [id=" + id + ", email=" + email + ", webPersonal=" + webPersonal + ","
				+ " imagen=" + imagen
				;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public Avatar(int id, String email, String webPersonal, String imagen, Persona persona) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
		this.imagen = imagen;
		this.persona = persona;
	}
	
	
	public Avatar(int id, String email, String webPersonal, String imagen) {
		super();
		this.id = id;
		this.email = email;
		this.webPersonal = webPersonal;
		this.imagen = imagen;
		
	}
	
}
