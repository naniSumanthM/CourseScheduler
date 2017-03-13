package com.CourseScheduler.service;

import com.CourseScheduler.dto.User;

public interface IUserService {

	/**
	 * Save the user and perform some front end validation
	 * 
	 * @param user
	 *            - the user object we are passing
	 * @throws Exception
	 *             if unable to save
	 */

	void save(User user) throws Exception;
	
	User fetchUser(String username, String password);
}
