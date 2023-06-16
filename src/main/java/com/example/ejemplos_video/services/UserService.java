package com.example.ejemplos_video.services;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//librerias utilizadas para la seguridad del usuario
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;


import com.example.ejemplos_video.entities.UserRole;
import com.example.ejemplos_video.repositories.IUserRepository;

@Service("userService")
public class UserService implements UserDetailsService{

	@Autowired
	@Qualifier("userRepository")
	private IUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException {
		com.example.ejemplos_video.entities.User user = userRepository.findByUsernameAndFetchUserRolesEagerly(username);
		return buildUser(user, buildGrantedAuthorities(user.getUserRoles()));
	}
	
	private User buildUser (com.example.ejemplos_video.entities.User user, List<GrantedAuthority> grandAuthorities) {
		return new User(user.getUsername(), user.getPassword(), user.isEnabled() ,
				true, true, true, grandAuthorities);//accountNonExpired, credentialsNonExpired, accountNonLocked,
		
	}
	
	private List<GrantedAuthority> buildGrantedAuthorities(Set<UserRole> userRoles){
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for(UserRole userRole : userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(grantedAuthorities);
	}

}



