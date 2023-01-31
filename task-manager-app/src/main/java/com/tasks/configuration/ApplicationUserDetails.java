package com.tasks.configuration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import org.springframework.security.core.userdetails.User;

import com.tasks.model.AppUser;
import com.tasks.repository.UserRepository;
 

@Service
public class ApplicationUserDetails implements UserDetailsService {

	@Autowired
	private UserRepository userRespository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String userName, password=null;
		List<GrantedAuthority> authorities=null;
	//	List<AppUser> users = userRespository.findByEmail(username);//this is for email based authentication
		List<AppUser> users= userRespository.findByName(username);
		if (CollectionUtils.isEmpty(users)) {
			throw new UsernameNotFoundException("user "+ username+" is not found!");	
		}
		
		userName=users.get(0).getEmail();
		password=users.get(0).getPassword();
		authorities=new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(users.get(0).getRole()));
		
		
		return new User(username, password, authorities);
	}

}
