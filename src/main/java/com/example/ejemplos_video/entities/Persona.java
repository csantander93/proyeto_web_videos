package com.example.ejemplos_video.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="persona")
public class Persona {
	
	//columnas que no estan en models
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//Las mismos de la capa models
	@Column(name="apellido")
	private String apellido;
	
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="dni")
	private long dni;
	
	@Column(name="pais")
	private String pais;
	
	//Opcional datos que se suelen usar en la creacion de tablas
	@Column(name="creado")
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@Column(name="actualizado")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	//Se podria agregar @NotNull si se queire que la relación exista siempre
	@NotNull
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "avatar_id", referencedColumnName = "id")
	@JsonIgnore
	private Avatar avatar;
	
	public Persona() {}
	
	public Persona(int id ,String apellido, String nombres, long dni, String pais, Avatar avatar) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
		this.pais = pais;
		this.avatar = avatar;
	}
	
	public Persona(int id ,String apellido, String nombres, long dni, String pais) {
		super();
		this.id = id;
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
		this.pais = pais;

	}
	
	public Persona(String apellido, String nombres, long dni, String pais, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.apellido = apellido;
		this.nombres = nombres;
		this.dni = dni;
		this.pais = pais;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
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
	

	public String getPais() {
		return pais; 
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", apellido=" + apellido + ", nombres=" + nombres + ", dni=" + dni + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
