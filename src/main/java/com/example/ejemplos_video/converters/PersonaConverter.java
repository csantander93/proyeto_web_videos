package com.example.ejemplos_video.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.ejemplos_video.entities.Persona;
import com.example.ejemplos_video.models.PersonaModelo;

@Component("personaConverter")
public class PersonaConverter {
	
	@Autowired
	@Qualifier("avatarConverter")
	private AvatarConverter avatarConverter;
	
	public PersonaModelo entityToModel(Persona persona) {
		return new PersonaModelo(persona.getId(), persona.getApellido(), persona.getNombres(), persona.getDni(), persona.getPais(),
				avatarConverter.entityToModel(persona.getAvatar()));
	}
	
	public Persona modelToEntity(PersonaModelo personaModelo) {
		return new Persona(personaModelo.getId(), personaModelo.getApellido(), personaModelo.getNombres(), personaModelo.getDni(), personaModelo.getPais(), 
				avatarConverter.modelToEntity(personaModelo.getAvatar()));
	}

}
