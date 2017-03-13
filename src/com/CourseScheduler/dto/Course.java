package com.CourseScheduler.dto;

//should be faces bean in course.
import javax.annotation.ManagedBean;
import javax.inject.Named;

@Named
@ManagedBean
public class Course {
	
	private int guid;
	private String subject;
	private String number;
	private String name;
	private String instructor;

	public int getGuid() {
		return guid;
	}

	public void setGuid(int guid) {
		this.guid = guid;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
}
