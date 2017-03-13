package com.CourseScheduler.dao;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;

import com.CourseScheduler.dto.Course;

public class CourseHbmDAO implements ICourseDAO {
	
	@Override
	public void insert(Course course) throws Exception {
		// save the user to the database.
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(course);
		session.getTransaction().commit();
	}

	@Override
	public void update(Course course) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Course course) throws Exception {
		// TODO Auto-generated method stub

	}
	
	@Override
	public List<Course> fetchCourses() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// create the query
		org.hibernate.Query query = session.createQuery("from Course");
		@SuppressWarnings("rawtypes")
		List list = query.list();
		
		List<Course> courses = Collections.checkedList(list, Course.class);
		
		return courses;
	}
	
	@Override
	public List<Course> fetchCourses(Course course) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// create the query
		org.hibernate.Query query = session.createQuery("from Course where subject like :subject"
				+ " and number like :number"
				+ " and name like :name"
				+ " and instructor like :instructor");
		query.setParameter("subject", "%" + course.getSubject() + "%");
		query.setParameter("number",  "%" + course.getNumber() + "%");
		query.setParameter("name", "%" + course.getName() + "%");
		query.setParameter("instructor", "%" + course.getInstructor() + "%");
		// query.setProperties(plant);
		@SuppressWarnings("rawtypes")
		List list = query.list();
		
		List<Course> courses = list;
		
		return courses;
	}
}
