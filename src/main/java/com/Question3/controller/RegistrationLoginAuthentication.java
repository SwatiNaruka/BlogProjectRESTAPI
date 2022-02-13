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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Question3.model.RegistrationUser;
import com.Question3.service.RegistrationAuthenticationService;




@RestController
@RequestMapping("/api")
public class RegistrationLoginAuthentication {

	@Autowired
	RegistrationAuthenticationService service;
		
	
	@PostMapping("/registerUser")
	public ResponseEntity<RegistrationUser> newUserRegistration(@RequestBody RegistrationUser reg) {
		System.out.println(reg.getName());
		System.out.println("hello");
		RegistrationUser regUser =  service.save(reg);
		
		
	return new ResponseEntity<RegistrationUser>(regUser,HttpStatus.OK);	
	}
	
	
	
	@GetMapping("/registerUser")
	public  ResponseEntity<List<RegistrationUser>> getAllUser() {
		
		List<RegistrationUser> reg = service.getuser();
		
		return new ResponseEntity<List<RegistrationUser>>(reg,HttpStatus.OK);
		
	}
	
	@PostMapping("/Authentication")
	public ResponseEntity<RegistrationUser> userAuthentication(@RequestBody RegistrationUser reg){
		int status =  service.authentication(reg);
		/*
		 * if(status>0) { System.out.println("loginSucess  from controller Message");
		 * }else { System.out.println("login failed from coltroller message"); }
		 */
		return new ResponseEntity<RegistrationUser>(reg,HttpStatus.OK);	
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<RegistrationUser> deleteUser(@RequestBody RegistrationUser reg){
		int status =  service.delete(reg);
		if(status > 0) {

			return new ResponseEntity<RegistrationUser>(reg,HttpStatus.OK);	 
		}
		return new ResponseEntity<RegistrationUser>(reg,HttpStatus.BAD_REQUEST);	
	}
	
	@PutMapping("/update")
	public ResponseEntity<RegistrationUser> updateUser(@RequestBody RegistrationUser reg){
		int status =  service.updateUser(reg);
		if(status > 0) {

			return new ResponseEntity<RegistrationUser>(reg,HttpStatus.OK);	 
		}
		return new ResponseEntity<RegistrationUser>(reg,HttpStatus.BAD_REQUEST);	
	}
}

