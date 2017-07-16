package org.arpit.java2blog.mock;

import org.arpit.java2blog.api.ProfileAPI;
import org.arpit.java2blog.bean.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository("mockservice")
public class MockProfileService implements ProfileAPI{

	@Override
	public User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateUser() {
		// TODO Auto-generated method stub
		return false;
	}

}
