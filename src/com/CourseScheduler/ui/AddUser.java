package com.CourseScheduler.ui;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import com.CourseScheduler.dto.User;
import com.CourseScheduler.service.IUserService;

@Named
@ManagedBean
@Scope("request")
public class AddUser {
	
	@Inject
	private User user;
	
	@Inject
	private IUserService userService;
		
	public String execute() {

		String output = "";
		
		// get faces context
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		
		try {
			userService.save(user);
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Saved", "User Saved");
			currentInstance.addMessage(null, fm);
			
		} catch (Exception e) {
			e.printStackTrace();
			output = "fail";
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to Save", "User not saved");
			currentInstance.addMessage(null, fm);
		}
		
		return output;
	}

}
