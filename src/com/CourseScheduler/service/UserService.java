package com.CourseScheduler.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.CourseScheduler.dao.IUserDAO;
import com.CourseScheduler.dto.User;

@Named
public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;

	@Override
	public void save(User user) throws Exception 
	{
		if (user == null ||
			user.getFirstName().isEmpty() ||
			user.getLastName().isEmpty() ||
			user.getEmailId().isEmpty() ||
			user.getPassword().isEmpty() ||
			user.getConfirmPassword().isEmpty() ||
			user.getMajor().isEmpty())
		{
			throw new Exception("All fields required");
		}
		else
		{
			userDAO.insert(user);
		}
	}
	
	@Override
	public User fetchUser(String email, String password) {
		User authUser = new User(email, password);
		User user = userDAO.fetchUser(authUser);
		return user;
	}

	public IUserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(IUserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
