package com.CourseScheduler.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named
@Scope("request")
@ManagedBean

public class AfterSignUp {

	public String userSignedUp() {
		return "index";
	}
}
