package com.CourseScheduler.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.CourseScheduler.dto.Course;

@Named
@ManagedBean
@Scope("session")
public class CourseVO {
	
	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

}
