package com.CourseScheduler.dao;

import java.util.List;

import javax.inject.Named;

import com.CourseScheduler.dto.Course;

@Named("courseDAO")
public class CourseDAOStub implements ICourseDAO {
	
	@Override
	public List<Course> fetchCourses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> fetchCourses(Course course) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insert(Course course) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Course course) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Course course) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
