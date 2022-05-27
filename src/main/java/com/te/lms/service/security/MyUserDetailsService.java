package com.te.lms.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.te.lms.security.dao.UserInfoDao;
import com.te.lms.security.entity.UserInfo;
import com.te.lms.security.pojo.MyUserDetails;

@Service
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                   UserInfo userInfo = userInfoDao.findByUserName(username);
               	if (userInfo!=null) {
        			return new MyUserDetails(userInfo);
        		}
        		throw new UsernameNotFoundException("user not found");
        	}
	}
	
	

