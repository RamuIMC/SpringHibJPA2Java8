package com.project.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.project.dao.UserDao;
import com.project.model.User;
import com.project.model.UserRole;

public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired 
	UserDao userDao;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		User user = userDao.getUserByName(userName);
	/*	
		boolean enabled = user.isActive();
		boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;*/
        
        List<String> roles = new ArrayList<String>();
        for(UserRole userRole :user.getUserRoles()){        	
        	roles.add(userRole.getRole().getRolename());
        }
        return new org.springframework.security.core.userdetails.User(userName, user.getPassword(), getAuthorities(roles));
     		
	}
	public Collection<? extends GrantedAuthority> getAuthorities(List<String> role) {
		 List<GrantedAuthority> authList = getGrantedAuthorities(role);
	        return authList;
	}

	public List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
       
       for (String role : roles) {
           authorities.add(new SimpleGrantedAuthority(role));
       }
       return authorities;
	}

}
