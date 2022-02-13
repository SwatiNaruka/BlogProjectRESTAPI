package com.Question3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Question3.dao.RegistrationDao;
import com.Question3.model.RegistrationUser;
import java.util.List;
@Service
public class RegistrationAuthenticationService {
		
		@Autowired 
		RegistrationDao dao;

		public RegistrationUser save(RegistrationUser reg) {
			RegistrationUser r = this.dao.addUser(reg);
			// TODO Auto-generated method stub
			return r;
		}

		public List<RegistrationUser> getuser() {
			// TODO Auto-generated method stub
			List<RegistrationUser> r = this.dao.findAll();
			return r;
		}
		
		
		public int authentication(RegistrationUser reg) {
		int id =reg.getRegistrationId();
		String  password= reg.getPassword();
		int status = 0;
		
		List<RegistrationUser> r = this.dao.findAll();
		
		for(RegistrationUser list : r) {
			/*
			 * if(id==(list.getRegistrationId()) || password.equals(list.getPassword())) {
			 * System.out.println("your failed: " +list.getName());
			 * 
			 * return 0; }
			 */
			if(id==(list.getRegistrationId()) && password.equals(list.getPassword())) {
				  System.out.println("login sucess: " +list.getName());
				  status++;
				  break;
			  
			  }else if(id == list.getRegistrationId() || password.equals(list.getPassword())) {
				  System.out.println("login failed");
				  status--;
				  break;
			  	}
			  }			
		/*	if(id == list.getRegistrationId()) {	
				if(password.equals(list.getPassword())) {
					System.out.println("login sucess : " +list.getName());
				}else {
					System.out.println("login failed due to wrong pass word " +list.getName());
					}
				}
			if(id != list.getRegistrationId()) {
				System.out.println("please insert the currect id");}			
			}*/	
			return status;
		}

		public int delete(RegistrationUser reg) {
			// TODO Auto-generated method stub
		int status=	dao.delete(reg);
			return status;
		}

		public int updateUser(RegistrationUser reg) {
			// TODO Auto-generated method stub
			 
			return this.dao.updateUser(reg);
		}
		
}
