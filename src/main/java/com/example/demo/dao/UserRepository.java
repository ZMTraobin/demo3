package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long>{
	
	UserInfo findByUname(String uname);
	
	UserInfo findById(long id);
	
	Page<UserInfo> findByUnameOrId(String uname,long id,Pageable  pageable);

}
