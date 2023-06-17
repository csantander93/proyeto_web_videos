package com.example.ejemplos_video.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class PersonaModelo {
	
	private int id;
	
	@Size (min = 3, max = 15)
	@Pattern(regexp = "^[A-Za-z]+$", message = "El apellido solo debe contener caracteres")
	private String apellido;
	
	@Size (min = 3, max = 30)
	@Pattern(regexp = "^[A-Za-z]+$", message = "El nombre solo debe contener caracteres")
	private String nombres;
	@Min(500000)
	@Max(99999999)
	private long dni;
	
	private AvatarModelo avatar;
   
	public AvatarModelo getAvatar() {
		return avatar;
	}

	public void setAvatar(AvatarModelo avatar) {
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni + "]";
	}

	public PersonaModelo() {}
	
	public PersonaModelo(int id,
			@Size(min = 3, max = 15) @Pattern(regexp = "^[A-Za-z]+$", message = "El apellido solo debe contener caracteres") String apellido,
			@Size(min = 3, max = 30) @Pattern(regexp = "^[A-Za-z]+$", message = "El nombre solo debe contener caracteres") String nombres,
			@Min(500000) @Max(99999999) long dni, AvatarModelo avatar) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
		this.avatar = avatar;
	}
	
	public PersonaModelo(int id,
			@Size(min = 3, max = 15) @Pattern(regexp = "^[A-Za-z]+$", message = "El apellido solo debe contener caracteres") String apellido,
			@Size(min = 3, max = 30) @Pattern(regexp = "^[A-Za-z]+$", message = "El nombre solo debe contener caracteres") String nombres,
			@Min(500000) @Max(99999999) long dni) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;

	}
	
	

}
