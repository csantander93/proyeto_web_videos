package com.example.ejemplos_video.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="pais")
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int ranking;
	
	@ManyToMany(mappedBy = "paises")
	public Set<Persona> persona = new HashSet<>();
	
	public Pais() {}

	public Pais(int id, String name, int ranking, Set<Persona> persona) {
		super();
		this.id = id;
		this.name = name;
		this.ranking = ranking;
		this.persona = persona;
	}

	public int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public Set<Persona> getPersona() {
		return persona;
	}

	public void setPersona(Set<Persona> persona) {
		this.persona = persona;
	}
	
	
	
}
