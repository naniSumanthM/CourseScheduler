package com.CourseScheduler.dao;

import java.util.Collections;

import javax.inject.Named;

import org.hibernate.Session;

import com.CourseScheduler.dto.Schedule;

@Named
public class ScheduleHbmDAO {
	
	/*
	@Override
	public List<Course> fetchByUserId(int userId) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// create the query
		org.hibernate.Query query = session.createQuery("from Specimen where plantId = :plantId");
		query.setParameter("plantId", plantId);
		// query.setProperties(plant);
		@SuppressWarnings("rawtypes")
		List list = query.list();
		
		List<Course> specimens = Collections.checkedList(list, Schedule.class);
		
		return specimens;
	}
	
	@Override
	public void insert(Session session, Schedule dto) throws Exception {
		// TODO Auto-generated method stub
		session.save(dto);
	}*/

}
