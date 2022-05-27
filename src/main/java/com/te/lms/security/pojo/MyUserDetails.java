package com.te.lms.security.pojo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.te.lms.security.entity.UserInfo;

public class MyUserDetails implements UserDetails{

	private UserInfo userInfo;

	public MyUserDetails(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userInfo.getUserRoles());
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		authorities.add(authority);
		return authorities;
	}

	@Override
	public String getPassword() {
		return userInfo.getUserPassword();
	}

	@Override
	public String getUsername() {
		return userInfo.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
