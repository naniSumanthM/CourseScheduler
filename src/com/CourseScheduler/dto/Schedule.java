package com.CourseScheduler.dto;

import java.util.List;

import javax.inject.Named;

@Named
public class Schedule {
	
	private int userId;
	private List<Course> schedule;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Course> getSchedule() {
		return schedule;
	}

	public void setSchedule(List<Course> schedule) {
		this.schedule = schedule;
	}

}
