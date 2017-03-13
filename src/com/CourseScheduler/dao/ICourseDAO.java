package com.CourseScheduler.dao;

import java.util.List;

import com.CourseScheduler.dto.Course;

public interface ICourseDAO {
	
	public List<Course> fetchCourses();
	
	List<Course> fetchCourses(Course course);

	public void insert(Course course) throws Exception;

	public void update(Course course) throws Exception;

	public void delete(Course course) throws Exception;
}
