package com.example.ejemplos_video.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.example.ejemplos_video.helpers.ViewRouteHelpers;
import com.example.ejemplos_video.models.PersonaModelo;
import com.example.ejemplos_video.services.IPersonaService;

import jakarta.validation.Valid;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("personas")
public class PersonController {
	
	@Autowired
	@Qualifier("personaService")
	private IPersonaService personaService;
	
	@GetMapping("/tablaPersonas")
	public ModelAndView mostrarTablaPersonas() {
		
	    ModelAndView mV = new ModelAndView(ViewRouteHelpers.PERSONAS);
	    mV.addObject("listaPersonas", personaService.getAll());
	    return mV;
	}
	
	@GetMapping("/eliminarPersona/{id}")
	public ModelAndView  eliminarPersona(@PathVariable("id")int id, Model model) {	
		
		personaService.remove(id);
			
		return mostrarTablaPersonas();	
	}
	
	@GetMapping("/editarPersona/{id}")
	public ModelAndView  editarPersona(@PathVariable("id")int id, Model model) {	
		
		PersonaModelo persona = personaService.traerPorId(id);

		model.addAttribute("persona", persona);
			
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelpers.PERSONA_FORM);
		
		
		return modelAndView;	
	}

	//Autorizo solo al usuario que cuenta con ese rol para usar este mapping del controlador personas
//	@PreAuthorize("hasrole('ROLE_ADMIN')")
	@GetMapping("/crearPersona")
	public ModelAndView crearPersona(Model model) {
		model.addAttribute("persona", new PersonaModelo());
		
		//User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		ModelAndView modelAndView = new ModelAndView(ViewRouteHelpers.PERSONA_FORM);
		//modelAndView.addAllObjects("usuario", user);
		return modelAndView;
	}
	
	@PostMapping("/nuevapersona")
	public ModelAndView nuevaPersona(@Valid @ModelAttribute("persona") PersonaModelo persona, 
			BindingResult b, @RequestParam("file") MultipartFile imagen) {
		
		ModelAndView mV = new ModelAndView();
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelpers.PERSONA_FORM);
		}else {
			
			if(!imagen.isEmpty()) {
				
				Path directorioImagenes = Paths.get("src//main//resources//static//images");
				
				String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();
				
				try {
					byte[] bytesImg = imagen.getBytes();
					Path rutaCompleta = Paths.get(rutaAbsoluta + "//" + imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytesImg);
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			//Modificamos el insertar de la persona para que se inserte el avatar tambien...
			personaService.insertOrUpdate(persona);
			
			mV.setViewName(ViewRouteHelpers.PERSONA_NEW);
			mV.addObject("persona", persona);
			
			//Podriamos tambien agregarle las personas que tenemos en la Base de Datos
			mV.addObject("listaPersonas" , personaService.getAll());
		}
		
		return mV;
	}
}
