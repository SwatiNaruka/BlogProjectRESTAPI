package com.Question3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.Question3.model.RegistrationUser;

@Component
public class RegistrationDao {
	
	@Autowired
	DbConnection dbcon;
	
	
	
	public RegistrationUser addUser(RegistrationUser reg) {
		// TODO Auto-generated method stub
		Connection con = dbcon.getConnection();
		
		try {
			
			Statement stmt= con.createStatement();
		
		String sql = "insert into registration value("+reg.getRegistrationId()+",'"+reg.getName()+"','"+reg.getPassword()+"','"+reg.getEmail()+"','"+reg.getGender()+"')"; 
	
		System.out.println(reg.getName());
		stmt.execute(sql);
	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reg;
	}
	
	

	public List<RegistrationUser> findAll() {
		// TODO Auto-generated method stub
		Connection con = dbcon.getConnection();
		List<RegistrationUser> list = new ArrayList<RegistrationUser>();
		try {
			Statement stmt= con.createStatement();
			String sql = "select *from registration";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				RegistrationUser x = new RegistrationUser();
				x.setRegistrationId(Integer.parseInt(rs.getString(1)));
				x.setName(rs.getString(2));
				x.setPassword(rs.getString(3));
				x.setEmail(rs.getString(4));
				x.setGender(rs.getString(5));
				list.add(x);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}



	public int delete(RegistrationUser reg) {
		// TODO Auto-generated method stub
		Connection con = dbcon.getConnection();
		try {
			Statement stmt= con.createStatement();
			String sql = "delete from registration where registrationId = "+reg.getRegistrationId()+"";
			int status  = stmt.executeUpdate(sql);
			return status;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	
	}



	public int updateUser(RegistrationUser reg) {
		Connection con = dbcon.getConnection();
		try {
			Statement stmt= con.createStatement();
			String sql = "update registration set name = '"+reg.getName()+"', password= '"+reg.getPassword()+"', email = '"+reg.getEmail()+"', gender='"+reg.getGender()+"' where registrationId ="+reg.getRegistrationId()+" ";
			int status  = stmt.executeUpdate(sql);
			return status;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
