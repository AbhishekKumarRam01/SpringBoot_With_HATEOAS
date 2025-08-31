package com.abhi.it.entity;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;

@Data
public class User extends RepresentationModel<User>{
	private  Integer Id;
	private String name;
	private String email;
	

	
	
 
}
