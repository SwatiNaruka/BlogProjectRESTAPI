
package com.Question3.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.Question3.service.BlogPostService;
import com.Question3.model.Post;
import com.Question3.model.RegistrationUser;
@RestController
public class BlogPostController {
			
	@Autowired
	BlogPostService service;
	
	@Value("${file.upload-dir}")
	String FILE_DIR;
	
	@PostMapping("/blog")
	public  ResponseEntity<Post> addNewBlog(@RequestParam("file") MultipartFile file,HttpSession session, @ModelAttribute("data") Post post) {
		System.out.println(post.getRegistrationId());
		System.out.println(post.getPost_title());
		System.out.println(post.getFile());
		
		 try {
			 String path = session.getServletContext().getRealPath("/resources/upload/");			
			 String filename =file.getOriginalFilename();
			  System.out.println(path+ " " +filename);
			
			  if(!file.getOriginalFilename().isEmpty()) {
				 BufferedOutputStream outputStream = new BufferedOutputStream(
							new FileOutputStream(
									new File(path, file.getOriginalFilename())));
					outputStream.write(file.getBytes());
					outputStream.flush();
					outputStream.close();
					int status =service.addpost(post);
					if(status >0) {
						System.out.println("image is uploaded");
						return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST);
					}else {
						 return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST);
					}					
					
				 }else {
				  return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST); 
				 }
			 }catch(Exception e) {
				 return new ResponseEntity<Post>(HttpStatus.BAD_REQUEST); 
			 }
	
		
		/*
		 * int status= service.addpost(post); if(status > 0) { return new
		 * ResponseEntity<Post>(HttpStatus.OK); }else return new
		 * ResponseEntity<Post>(HttpStatus.BAD_REQUEST);
		 */
	}
	
	@PutMapping("/blog")
	public  ResponseEntity<Post> updateBlog(@RequestBody Post post) {
		int status = service.updatePost(post);
		if(status > 0) {
			System.out.println(status);
			return new ResponseEntity<Post>(HttpStatus.OK);	
		}
		else {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	}
	
	@DeleteMapping("/blog")
	public  ResponseEntity<Post> deleteBlog(@RequestBody Post post) {
		int status = service.deletePost(post);
		if(status > 0) {
			System.out.println(status);
			return new ResponseEntity<Post>(HttpStatus.OK);	
		}
		else {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	} 
	
	@GetMapping("/blog")
	public  ResponseEntity<List<Post>> getAllBlog() {
		List<Post> list= service.getAllPost();
		if(list != null ) {
			
			return new ResponseEntity<List<Post>>(list,HttpStatus.OK);
			
		}
		else {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		}
	} 
	
	
	
	
	
	
}
