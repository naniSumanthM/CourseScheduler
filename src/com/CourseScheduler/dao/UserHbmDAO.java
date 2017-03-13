package com.CourseScheduler.dao;

import java.util.List;

import org.hibernate.Session;
import com.CourseScheduler.dto.User;

public class UserHbmDAO implements IUserDAO {

	@Override
	public void insert(User user) throws Exception {
		// save the user to the database.
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

	@Override
	public void update(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public User fetchUser(User user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		// create the query
		org.hibernate.Query query = session.createQuery("from User where EmailId = :emailId"
				+ " and password = :password");
		query.setParameter("emailId", user.getEmailId());
		query.setParameter("password", user.getPassword());
		
		// This should probably be checked
		return (User) query.uniqueResult();
	}

}
