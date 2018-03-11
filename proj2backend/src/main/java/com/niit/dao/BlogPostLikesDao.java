package com.niit.dao;

import com.niit.model.BlogPostLikes;

public interface BlogPostLikesDao {
BlogPostLikes hasUserLikedBlog(int id,String email);
BlogPostLikes updateLikes(int id,String email);
}
