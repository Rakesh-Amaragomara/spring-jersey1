package org.arpit.java2blog.controller;

import java.net.URISyntaxException;

import javax.ws.rs.core.Response;

import org.arpit.java2blog.api.ProfileAPI;
import org.arpit.java2blog.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;



public class NavigatorService {
	@Autowired
	@Qualifier("restProfileService")
	ProfileAPI profileAPI;

	public User getProfile() throws URISyntaxException {
		// TODO Auto-generated method stub
		 //java.net.URI location = new java.net.URI("www.google.com");
	
		User user=new User();
		user.setId(2);
		return user;
		
	}
}
