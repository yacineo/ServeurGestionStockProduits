package com.example.demo.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	private boolean accountNonExpired =true;
	private boolean credentialsNonExpired = true;
	private boolean accountNonLocked = true;
	private Collection<? extends GrantedAuthority> authorities;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		this.authorities = getAuthorities(user.getRoles());
		UserDetails userDetails = new org.springframework.security.core.
				userdetails.User(username, 
						user.getPassword(), 
				user.isEnable(), 
				accountNonExpired, 
				credentialsNonExpired, 
				accountNonLocked, 
				authorities);
		return userDetails;
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(List<Role> roles) {
		
		Collection< GrantedAuthority> auth=new ArrayList<GrantedAuthority>();
		for (Role role : roles) {
			GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
			auth.add(authority);
		}
		
		return auth;
	}

}
