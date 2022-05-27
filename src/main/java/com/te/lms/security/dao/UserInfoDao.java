package com.te.lms.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.security.entity.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
public UserInfo findByUserName(String userName); 
}
