package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.UserConnectvity;
import com.Entity.User;

@Service
public class Userservice {

	
	@Autowired
	UserConnectvity userdata;
	
	public Userservice() {
		// TODO Auto-generated constructor stub
	}
	public Optional<User> Checkuser(User user) {
		
		String name=user.getName();
		String password=user.getPassword();
		String type=user.getType();
		return userdata.findByNameAndPasswordAndType(name, password,type);
	}

}
