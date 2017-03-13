package com.CourseScheduler.dao;

import com.CourseScheduler.dto.User;


public interface IUserDAO {
	//public List<User> fetchPlants();

	public void insert(User user) throws Exception;

	public void update(User user) throws Exception;

	public void delete(User user) throws Exception;
	
	public User fetchUser(User user);
}
