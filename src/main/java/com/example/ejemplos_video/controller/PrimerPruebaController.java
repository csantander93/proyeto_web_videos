package com.example.ejemplos_video.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.ejemplos_video.helpers.ViewRouteHelpers;

@Controller
@RequestMapping("/primerprueba")

public class PrimerPruebaController {
	
	@GetMapping("iniciando")
	public String iniciandoPrueba () {
		return ViewRouteHelpers.INDEX_INICIANDO;
	}
	
	@GetMapping("/nombre") // ?nombre_variable=Cristian
	public ModelAndView cambiarNombreNuevo(@RequestParam(name="nombre_variable", required=true, defaultValue="null") String nombre_variable ) {
		ModelAndView modelV = new ModelAndView(ViewRouteHelpers.INDEX2);
		
		modelV.addObject("variableParaTemplate", nombre_variable);
		return modelV;
	}
	
	@GetMapping("/nombre/{nombre_variable}")
	public ModelAndView cambiarNombre(@PathVariable("nombre_variable")String nombre_variable) {
		ModelAndView modelV = new ModelAndView(ViewRouteHelpers.INDEX2);
		
		modelV.addObject("variableParaTemplate", nombre_variable);
		return modelV;
	}
	
	@GetMapping("")
	public String inicio() {
		return ViewRouteHelpers.INDEX;
	}

}
