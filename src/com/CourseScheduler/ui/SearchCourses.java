package com.CourseScheduler.ui;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;

import com.CourseScheduler.dto.Course;
import com.CourseScheduler.service.ICourseService;

@Named
@ManagedBean
@Scope("session")
public class SearchCourses {

	@Inject
	private Course course;
	
	@Inject
	private ICourseService courseService;

	private List<Course> courses;
	
	private Course selectedCourse;
	
	/**
	 * Handle button clicks from searches.
	 * @return the next navigation.
	 */
	public String execute() {
		setCourses(courseService.fetchCourses(course));
		System.out.println("course: " + course.toString());
		System.out.println("corses: " + courseService.fetchCourses());
		System.out.println("corses(course): " + courseService.fetchCourses(course));
		return "search";
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
		
	}

	public List<Course> completeCourses(String query) {
		return courseService.filterCourses(query);
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> course) {
		this.courses = course;
	}

	public Course getSelectedCourse() {
		return selectedCourse;
	}

	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

    public void onRowSelect(SelectEvent event) throws Exception {  
        Course course = ((Course) event.getObject());
        setSelectedCourse(course);
		FacesContext.getCurrentInstance().getExternalContext().redirect("course.xhtml");
    }

}
