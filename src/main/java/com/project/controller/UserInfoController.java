package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
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
		
		ClientConfig clientConfig = new ClientConfig();
		ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
		networkConfig.addAddress("192.168.100.5");
		
		HazelcastInstance client = HazelcastClient.newHazelcastClient( clientConfig );
        IMap map = client.getMap("customers");
        System.out.println( "Map Size:" + map.size() );
        map.put( 1, "Joe" );
        map.put( 2, "Ali" );
        map.put( 3, "Avi" );
       
        System.out.println( "Map Size:" + map.size() );
		
		userDto.setUserId(user.getId());
		userDto.setUserName(user.getUserName());
		
	return userDto;
	
	}
	
	

}
