package com.Question3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question3.dao.BlogPostDao;
import com.Question3.model.Post;

@Service
public class BlogPostService {

	@Autowired
	BlogPostDao dao;
	
	public int  addpost(Post post) {
	 	return dao.addPost(post);
	}

	public int updatePost(Post post) {
		// TODO Auto-generated method stub
	int status=	dao.updatePost(post);
	
	return status;
	}

	public int deletePost(Post post) {
		// TODO Auto-generated method stub
	int status =dao.deletepost(post);
	
	return status;
	}
	
	public List<Post> getAllPost() {
		
		List<Post> list =dao.allPost();
		return list;
	}
	
}

