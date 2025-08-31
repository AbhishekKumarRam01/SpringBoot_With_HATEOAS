package com.abhi.it.entity;

import org.springframework.hateoas.RepresentationModel;


public class User extends RepresentationModel<User>{
	private  Integer Id;
	private String name;
	private String email;
	
	public User() {
		super();
	}
	public User(Integer id, String name, String email) {
		super();
		Id = id;
		this.name = name;
		this.email = email;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [Id=" + Id + ", name=" + name + ", email=" + email + "]";
	}
	
	
 
}
