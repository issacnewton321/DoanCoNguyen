package com.abc.jwt.configs;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.abc.entity.Nguoidung;

public class UserPrinciple implements UserDetails{
	
	Nguoidung nguoidung;
	
	
	
	public UserPrinciple(Nguoidung nguoidung) {
		super();
		this.nguoidung = nguoidung;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("USER"));
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return nguoidung.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return nguoidung.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
