package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.UserInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

	    @Autowired
	    private UserRepository userRepository;

	    //查询所有的数据
	    @Test
	    public void test() throws Exception {
	        /*List<UserInfo> listUser = userRepository.findAll();
	        for (UserInfo user : listUser) {
			 System.out.println(user.toString());
		    }*/
	    	UserInfo info = new UserInfo();
	    	info.setUname("admin");
		    info.setPassword("admin");
		    info.setAge("8");
	        // userRepository.findAll();
	        //System.out.println(userRepository.findById(1l));
	        /* userRepository.save(info);
	        userRepository.delete(info);*/
		    Pageable pageable = null;
	        Sort sort = new Sort(Sort.Direction.DESC, "id");
	        pageable = PageRequest.of(0, 2, sort);
	        Page<UserInfo> pageUsers = userRepository.findByUnameOrId(info.getUname(),1, pageable);
		    for (UserInfo u : pageUsers.getContent()) {
		    	System.out.println(u.toString());
				
			}
	        //userRepository.count();
	        //userRepository.existsById(1l);
	       
	    }
	    //批量添加数据
	   /*@Test
	    public void insertTest() throws Exception {
	       UserInfo info = new UserInfo();
	       info.setUname("admin4");
	       info.setPassword("admin");
	       info.setAge("8");
	       List<UserInfo> listUser = new ArrayList<>(); 
	       listUser.add(info);
	       userRepository.saveAll(listUser);
	    }
	    @Test
	    public void deleteTest() throws Exception {
	    	List<UserInfo> listUser = new ArrayList<>(); 
	       for (int i = 8; i < 12; i++) {
	    	   UserInfo info = new UserInfo();
		       info.setId(i);
		       listUser.add(info);
		}
	       //根据id进行删除
	       userRepository.deleteInBatch(listUser);
	      
	    }*/
}
