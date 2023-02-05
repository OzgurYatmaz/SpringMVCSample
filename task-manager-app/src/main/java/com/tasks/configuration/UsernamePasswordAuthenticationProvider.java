package com.tasks.configuration;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.tasks.model.AppUser;
import com.tasks.repository.UserRepository;


@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username=authentication.getName();
		String password=authentication.getCredentials().toString();
		System.out.println("username: "+username+" password: "+password);
		List<AppUser> users = userRepository.findByName(username);
		if(!CollectionUtils.isEmpty(users)) {
			AppUser user = users.get(0);
			if(encoder.matches(password, user.getPassword())) {
				List<GrantedAuthority> authorities=new ArrayList<>();
				authorities.add(new SimpleGrantedAuthority(user.getRole()));
				return new UsernamePasswordAuthenticationToken(username, password, authorities);
			}else {
				throw new BadCredentialsException("invalid password!");
			}
		}else {
			throw new BadCredentialsException("No user registered with this details");
		}
	}


 

	@Override
	public boolean supports(Class<?> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
