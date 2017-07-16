package org.arpit.java2blog.service;

import org.arpit.java2blog.api.ProfileAPI;
import org.arpit.java2blog.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository("profileservice")
public class RestProfileService implements ProfileAPI{

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(1);
		return user;
	}

	@Override
	public boolean updateUser() {
		// TODO Auto-generated method stub
		return false;
	}

}
