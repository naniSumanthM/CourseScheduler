package com.CourseScheduler.ui;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.CourseScheduler.dto.Course;

@Named
@ManagedBean
public class UserSchedule {
	
	public void addCourse(SelectEvent event) {
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		
		System.out.println("Running...");
		
		try {
			Course course  = ((Course) event.getObject());
			System.out.println("Course added to schedule: " + course);
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Added", "Course Added");
			currentInstance.addMessage(null, fm);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Course failed to schedule: " + e);
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Course not saved");
			currentInstance.addMessage(null, fm);
		}
	}
	
	
	
	

}
