package com.CourseScheduler.ui;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.CourseScheduler.dto.Course;
import com.CourseScheduler.service.ICourseService;

@Named
@ManagedBean
@Scope("request")
public class AddCourse {
	
	@Inject
	private Course course;
	
	@Inject
	private ICourseService courseService;
		
	public String execute() {

		String output = "";
		
		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		
		try {
			courseService.save(course);
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "Course Saved");
			currentInstance.addMessage(null, fm);
			
		} catch (Exception e) {
			e.printStackTrace();
			output = "searchcourses";
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to Save", "Course not saved");
			currentInstance.addMessage(null, fm);
		}
		
		return output;
	}

}
