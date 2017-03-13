package com.CourseScheduler.service;

import java.util.List;

import com.CourseScheduler.dto.Course;

public interface ICourseService {
	
	public List<Course> filterCourses(String filter);
	
	List<Course> fetchCourses();
	
	List<Course> fetchCourses(Course course);
	
	void save(Course course) throws Exception;

}
