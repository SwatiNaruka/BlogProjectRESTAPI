package com.Question3.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Post {
		private int post_id;
		private String  post_title;
		private String post_description;
		private int registrationId;
		private MultipartFile file;
		
		public int getPost_id() {
			return post_id;
		}
		public void setPost_id(int post_id) {
			this.post_id = post_id;
		}
		public String getPost_title() {
			return post_title;
		}
		public void setPost_title(String post_title) {
			this.post_title = post_title;
		}
		public String getPost_description() {
			return post_description;
		}
		public void setPost_description(String post_description) {
			this.post_description = post_description;
		}
		public int getRegistrationId() {
			return registrationId;
		}
		public void setRegistrationId(int registrationId) {
			this.registrationId = registrationId;
		}
		public MultipartFile getFile() {
			return file;
		}
		public void setFile(MultipartFile file) {
			this.file = file;
		}
}
