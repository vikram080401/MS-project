//package com.ecommerce.shopping.app.webconfig;
//
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import com.ecommerce.shopping.app.model.CustomerLogins;
//
//
//@SuppressWarnings("serial")
//public class CustomUserDetails implements UserDetails {
//
//	@Autowired
//	private CustomerLogins user;
//
//	public CustomUserDetails(CustomerLogins user) {
//
//		this.user = user;
//		
//	}
//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String getPassword() {
//
//		return user.getPassword();
//
//	}
//
//	@Override
//	public String getUsername() {
//
//		return user.getCustomerusername();
//
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//
//		return true;
//	}
//	 public String getFullName() {
//	        return user.getCustomerusername() ;
//	    }
//
//}
