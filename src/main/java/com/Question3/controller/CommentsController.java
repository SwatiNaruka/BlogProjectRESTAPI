package com.Question3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Question3.model.Comments;
import com.Question3.model.Post;
import com.Question3.service.CommentsService;

@RestController
public class CommentsController {
	
	@Autowired
	CommentsService service;
	
	@PostMapping("comments")
	public  ResponseEntity<Comments> addComments(@RequestBody Comments com) {
		int status=	service.sendComment(com);
		if(status > 0) {
			return new ResponseEntity<Comments>(HttpStatus.OK);	
		}else
	return new ResponseEntity<Comments>(HttpStatus.BAD_REQUEST);	
	}
	
	@PutMapping("/comments")
	public  ResponseEntity<Comments> updateComments(@RequestBody Comments com) {
		int status = service.updateComents(com);
		if(status > 0) {
			return new ResponseEntity<Comments>(HttpStatus.OK);	
		}
		else {
		return new ResponseEntity<Comments>(HttpStatus.BAD_REQUEST);	
		}
	}
	
	
	@GetMapping("/comments")
	public  ResponseEntity<List<Comments>> getAllBlog() {
		List<Comments> list= service.findAll();
		if(list != null ) {			
			return new ResponseEntity<List<Comments>>(list,HttpStatus.OK);		
		}
		else {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	} 
	
	@DeleteMapping("/comments")
	public  ResponseEntity<Comments> deleteComents(@RequestBody Comments com) {
		int status = service.deleteComents(com);
		if(status > 0) {
			System.out.println(status);
			return new ResponseEntity<Comments>(HttpStatus.OK);	
		}
		else {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	} 
}
