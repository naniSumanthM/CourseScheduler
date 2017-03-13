package com.CourseScheduler.ui;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

import com.CourseScheduler.dto.User;
import com.CourseScheduler.service.UserService;

@Named
@Scope("request")
public class Authenticate {
	
	private String email;
	private String password;
	
	@EJB
    private UserService userService;

	public String login() {
		User user = userService.fetchUser(email, password);
		FacesContext currentInstance = FacesContext.getCurrentInstance();
		
		if (user == null) {
			FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Invalid Login", "Incorrect login information");
			currentInstance.addMessage(null, fm);
			this.email = null;
			this.password = null;
			return "index.xhtml";
		} else {
			currentInstance.getExternalContext().getSessionMap().put("auth", user);
	        return "searchcourses.xhtml?faces-redirect=true";
		}
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}	
	
}
