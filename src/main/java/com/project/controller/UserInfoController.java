package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.dao.UserDao;
import com.project.dto.UserDto;
import com.project.model.User;


@RestController
public class UserInfoController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/getuser/{id}",method=RequestMethod.GET)
	public UserDto getUserById(@PathVariable("id") int userId ){
		
		UserDto userDto = new UserDto();
		User user= userDao.getUserById(userId);
		
		userDto.setUserId(user.getId());
		userDto.setUserName(user.getUserName());
		
	return userDto;
	
	}
	
	

}
