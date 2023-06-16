package com.example.ejemplos_video.converters;

import org.springframework.stereotype.Component;

import com.example.ejemplos_video.entities.Avatar;
import com.example.ejemplos_video.models.AvatarModelo;

@Component("avatarConverter")
public class AvatarConverter {
	
	public AvatarModelo entityToModel(Avatar avatar) {
		
		return new AvatarModelo(avatar.getId(), avatar.getEmail(),avatar.getWebPersonal(),avatar.getImagen());	
	
	}
	
	public Avatar modelToEntity(AvatarModelo avatarModelo) {
		
		return new Avatar(avatarModelo.getId(), avatarModelo.getEmail(), avatarModelo.getWebPersonal(),avatarModelo.getImagen());
			
	}

}
