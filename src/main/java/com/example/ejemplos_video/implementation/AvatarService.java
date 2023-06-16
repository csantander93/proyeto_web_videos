package com.example.ejemplos_video.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.ejemplos_video.converters.AvatarConverter;
import com.example.ejemplos_video.entities.Avatar;
import com.example.ejemplos_video.models.AvatarModelo;
import com.example.ejemplos_video.repositories.IAvatarRepository;
import com.example.ejemplos_video.services.IAvatarService;


@Service("avatarService")
public class AvatarService implements IAvatarService {
	
	@Autowired
	@Qualifier("avatarRepository")
	private IAvatarRepository avatarRepository;
	
	@Autowired
	@Qualifier("avatarConverter")
	private AvatarConverter avatarConverter;
	
	@Override
	public List<Avatar> getAll(){	
		return avatarRepository.findAll();	
	}
	
	@Override
	public AvatarModelo insertOrUpdate(AvatarModelo avatarModelo) {
		
		Avatar avatar = avatarRepository.save(avatarConverter.modelToEntity(avatarModelo));
		
		return avatarConverter.entityToModel(avatar);
	}
	
	@Override
	public boolean remove(int id) {
		
		try {
			avatarRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	

}
