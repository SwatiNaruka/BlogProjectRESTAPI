package com.Question3.model;

import org.springframework.stereotype.Component;

@Component
public class Comments {

	private	String comments;
	private int post_id;
	private int registar_id;
	private int comment_id;
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public int getPost_id() {
		return post_id;
	}
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
	public int getRegistar_id() {
		return registar_id;
	}
	public void setRegistar_id(int registar_id) {
		this.registar_id = registar_id;
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	
}
