package com.example.ejemplos_video.services;

import java.util.List;

import com.example.ejemplos_video.entities.Persona;
import com.example.ejemplos_video.models.PersonaModelo;

public interface IPersonaService {
	
	public List<Persona> getAll();
	
	public PersonaModelo insertOrUpdate(PersonaModelo personaModelo);
	
	public boolean remove(int id);

}
