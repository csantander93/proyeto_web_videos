package com.example.ejemplos_video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ModelAndView nuevaPersona(@Valid @ModelAttribute("persona") PersonaModelo persona, BindingResult b) {
		
		ModelAndView mV = new ModelAndView();
		
		if(b.hasErrors()) {
			mV.setViewName(ViewRouteHelpers.PERSONA_FORM);
		}else {
			
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
