package com.example.ejemplos_video.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.ejemplos_video.helpers.ViewRouteHelpers;
import com.example.ejemplos_video.services.IAvatarService;

@Controller
@RequestMapping("avatar")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AvartarController {
		
		@Autowired
		@Qualifier("avatarService")
		private IAvatarService avatarService;
		
		@GetMapping("/listaAvatar")
		public ModelAndView mostrarTablaPersonas() {
			
		    ModelAndView mV = new ModelAndView(ViewRouteHelpers.AVATAR_VISTA);
		    mV.addObject("listaAvatar", avatarService.getAll());
		    
		    return mV;
		    
		}
}
