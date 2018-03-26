package com.niit.dao;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.BlogPostLikes;

@Repository
@Transactional
public class BlogPostLikesDaoImpl implements BlogPostLikesDao{
@Autowired
private SessionFactory sessionFactory;
public BlogPostLikes hasUserLikedBlog(int blogId, String email) {
	Session session=sessionFactory.getCurrentSession();
	Query query=session.createQuery("from BlogPostLikes where blogpost.id=? and user.email=?");
	query.setInteger(0,blogId);
	query.setString(1,email);
	BlogPostLikes blogPostLikes=(BlogPostLikes)query.uniqueResult();
	return blogPostLikes;
}
public BlogPostLikes updateLikes(int id, String email) {
	// TODO Auto-generated method stub
	return null;
}
}

