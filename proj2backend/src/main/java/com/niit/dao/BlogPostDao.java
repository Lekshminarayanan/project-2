package com.niit.dao;

import java.util.List;

import com.niit.model.BlogComment;
import com.niit.model.BlogPost;

public interface BlogPostDao {
void addBlogPost(BlogPost blogpost);
List<BlogPost> listOfBlogs(int approved);
BlogPost getBlog(int id);
void reject(BlogPost blog,String rejectionReason);
void approve(BlogPost blog);
void addBlogComment (BlogComment blogComment);
}
