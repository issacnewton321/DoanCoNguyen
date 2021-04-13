package com.abc.jwt.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abc.entity.Nguoidung;
import com.abc.repository.NguoidungRepository;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	NguoidungRepository repo;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
       Nguoidung nd = new Nguoidung();
       nd = repo.getById(s);
       if(nd == null) throw new UsernameNotFoundException(s);
       return new UserPrinciple(nd);
    }
}