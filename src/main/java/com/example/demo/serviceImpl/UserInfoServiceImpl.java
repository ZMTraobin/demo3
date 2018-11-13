package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.mapper.UserInfoDao;
import com.example.demo.service.UserInfoService;
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	
	@Autowired
	private UserInfoDao userInfoDao;

	@Override
	public List<UserInfo> findAll() {
		// TODO Auto-generated method stub
		return userInfoDao.findAll();
	}

}
