package com.example.ejemplos_video.services;

import java.util.List;

import com.example.ejemplos_video.entities.Avatar;
import com.example.ejemplos_video.models.AvatarModelo;

public interface IAvatarService {
	
	
	public List<Avatar> getAll();
	
	public AvatarModelo insertOrUpdate(AvatarModelo avatarModelo);
	
	public boolean remove(int id);

}


