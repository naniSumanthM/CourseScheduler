package com.CourseScheduler.dao;

import javax.inject.Named;
import com.CourseScheduler.dto.User;

@Named("userDAO") //?
public class UserDAOStub implements IUserDAO {

	@Override
	public void insert(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User fetchUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
