package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
/**
 * 实现Serializable序列化，可以将该对象进行redis序列化存储
 * @author Administrator
 *
 */
@Entity
@Table(name = "com.cmig.zrgk.user")

public class UserInfo implements Serializable{
	private final long serialVersionUID = 1L;
	//id主键
	@Id
	@GeneratedValue
	private long id;
	//nullabe:是否可以为空。unique:是否唯一
	@Column(nullable = false,unique = false)
	private String uname;
	@Column(nullable = false,unique = true)
	private String password;
	@Transient
	private String age;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo [serialVersionUID=" + serialVersionUID + ", id=" + id + ", uname=" + uname + ", password="
				+ password + ", age=" + age + "]";
	}
 
	

}
