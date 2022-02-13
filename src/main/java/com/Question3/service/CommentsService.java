package com.Question3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question3.dao.CommentsDao;
import com.Question3.model.Comments;

@Service
public class CommentsService {

	
	@Autowired
	CommentsDao dao;

	public int sendComment(Comments com) {
		// TODO Auto-generated method stub
		return  this.dao.sendComment(com);
		
	}

	public int deleteComents(Comments coment) {
		// TODO Auto-generated method stub
		return this.dao.deleteComment(coment);
	}

	public int updateComents(Comments coment) {
		// TODO Auto-generated method stub
		return this.dao.updateComments(coment);
	}

	public List<Comments> findAll() {
		// TODO Auto-generated method stub
		 List<Comments> list =dao.findComment();
		return list;
	}
}
