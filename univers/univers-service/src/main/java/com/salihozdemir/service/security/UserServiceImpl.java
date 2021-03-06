package com.salihozdemir.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salihozdemir.model.entity.User;
import com.salihozdemir.repository.security.UserRepository;

@Service
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUserName(username);
		return new CustomUserDetails(user.getUsername(), user.getPassword(), true, true, true, true, user.getAuthorities());
	}

}
