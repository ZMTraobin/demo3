package com.example.demo.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entity.UserInfo;
import com.example.demo.service.UserInfoService;
/**
 * 使用@RestController的注解默认操作参数返回值均以json格式进行
 * @author Administrator
 *
 */
@RestController
public class UserController {
	
	 private static Logger logger = LoggerFactory.getLogger(UserController.class);
	 
	    @Autowired
	    private RedisTemplate<Serializable, Object> redisTemplate;
	    
	    @Autowired
	    private UserInfoService userInfoService;
	 
	    @RequestMapping("/set")
	    public Object setPOJO(){
	 
	        UserInfo user = new UserInfo();
	        user.setAge("18");
	        user.setUname("小狗");
	        user.setPassword("ppp");
	        redisTemplate.opsForValue().set("user1", user);
	        return user;
	    }
	 
	    @RequestMapping("/get")
	    public Object getPOJO(){
	 
	        return redisTemplate.opsForValue().get("user1");
	    }

	 
	//直接获取配置文件中的初始化的参数值
	@Value("${com.cmig.uname}")
	private String uname;
	
	@RequestMapping("/hello")
	public Object login(String uName,String password) {
		Map<String, Object> map = new HashMap<>();
		map.put("password", password);
		map.put("uName", uName);
		UserInfo info = new UserInfo();
    	System.out.println(uname);
		return map;
	}
	
	@RequestMapping("/find")
	public Object findAllUser() {
		return userInfoService.findAll();
	}

}
