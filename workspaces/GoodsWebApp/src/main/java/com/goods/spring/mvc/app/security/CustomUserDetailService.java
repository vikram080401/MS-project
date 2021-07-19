package com.goods.spring.mvc.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;




import com.goods.spring.mvc.app.dao.CustomerLoginsRepository;
import com.goods.spring.mvc.app.model.CustomerLogins;


public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private CustomerLoginsRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		CustomerLogins user=repo.findByCustomerusername(username);
		
		
		if(user==null) {
			throw new UsernameNotFoundException("User not found");
		}
		else
		return new CustomUserDetails(user);
	}

}
