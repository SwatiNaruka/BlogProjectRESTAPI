package com.Question3.model;

import java.beans.JavaBean;

import org.springframework.stereotype.Component;


@Component
public class RegistrationUser {
		private int registrationId;
		private String name;
		private String password;
		private String email;
		private String gender;
		public int getRegistrationId() {
			return registrationId;
		}
		public void setRegistrationId(int registrationId) {
			this.registrationId = registrationId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
		
		
}
