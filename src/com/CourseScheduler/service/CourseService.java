package com.CourseScheduler.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.CourseScheduler.dao.ICourseDAO;
import com.CourseScheduler.dto.Course;

@Named
public class CourseService implements ICourseService {
	
	@Inject
	private ICourseDAO courseDAO;
	
	private List<Course> allCourses;
	
	@Override
	public List<Course> filterCourses(String filter) {
		if (allCourses == null ) {
			allCourses = getCourseDAO().fetchCourses();
		}
		
		List<Course> returnCourses = new ArrayList<Course>();

		for (Course course : allCourses) {
			if (course.toString().contains(filter)) {
				returnCourses.add(course);
			}
		}
		
		return returnCourses;
	}
	
	@Override
	public List<Course> fetchCourses() {
		return courseDAO.fetchCourses();
	}
	
	@Override
	public List<Course> fetchCourses(Course course) {
		List<Course> courses = courseDAO.fetchCourses(course);
		return courses;
	}

	@Override
	public void save(Course course) throws Exception 
	{
		if (course == null ||
			course.getSubject().isEmpty() ||
			course.getNumber().isEmpty() ||
			course.getName().isEmpty() ||
			course.getInstructor().isEmpty())
		{
			throw new Exception("All fields required");
		}
		else
		{
			courseDAO.insert(course);
		}
	}

	public ICourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(ICourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

}
