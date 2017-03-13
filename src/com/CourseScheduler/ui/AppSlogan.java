package com.CourseScheduler.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
@ManagedBean

public class AppSlogan {

	private String slogan = "One stop shop for course registration, tutorials, and textbooks";

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

}