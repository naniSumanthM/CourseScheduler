package com.CourseScheduler.ui;

import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import org.springframework.context.annotation.Scope;

@Named
@Scope("session")
@ManagedBean

public class Signup {

	public String singupAction() {

		return "signup";
	}
}