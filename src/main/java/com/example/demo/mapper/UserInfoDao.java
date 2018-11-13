package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.UserInfo;

public interface UserInfoDao {
	
	List<UserInfo> findAll();

}
