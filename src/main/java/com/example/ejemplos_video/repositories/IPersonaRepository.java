package com.example.ejemplos_video.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplos_video.entities.Persona;

@Repository("personaRepository")

public interface IPersonaRepository extends JpaRepository <Persona, Serializable>{
	
	//Metodos que se pueden llamar desde el controlador 
	//Si se utilizan nombres estandar como findBy,OrderBy, GroupBy, etc no hace falta
	//desarrollar las consultas, tambien se puede hacer bucarPorNombre, pero 
	//con esos nombres deberas programarlo de forma personal
	
	public abstract Persona findByApellido(String apellido);
	public abstract Persona findByDni(long dni);

}
