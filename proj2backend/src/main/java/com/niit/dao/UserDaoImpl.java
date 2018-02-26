package com.niit.dao;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
@Autowired
private SessionFactory sessionFactory;
 public UserDaoImpl() {
	 System.out.println("UserDaoImpl bean is created");
 }
	public void registerUser(User user) {
		System.out.println("registerUser in Dao" + user);
		Session session= sessionFactory.getCurrentSession();
		session.save(user);
	}
	public boolean isEmailUnique(String email) {
		boolean b;
		Session session= sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,email);
		if(user==null)
			b= true;
		else
			b= false;
		return b;
		
	}
	public User login(User user) {
		Session session=sessionFactory.getCurrentSession();
		Query<User> query=session.createQuery("from User where email=? and password=?");
		query.setString(0,user.getEmail());
		query.setString(1,user.getPassword());
		return (User)query.uniqueResult();
	}
	public void update(User validUser) {
		Session  session= sessionFactory.getCurrentSession();
		session.update(validUser);
	}
	public User getUser(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,email);
		return user;
	}
	public void updateUser(User user) {
		Session  session= sessionFactory.getCurrentSession();
		session.update(user);
	}
	
}
