package com.Question3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.Question3.model.Post;
import com.Question3.model.RegistrationUser;

@Repository
public class BlogPostDao {
		
	@Autowired
	DbConnection dbcon;
	
	public int addPost(Post post) {
		Connection con = dbcon.getConnection();
		
		   try {
			Statement stmt   = con.createStatement();
			String sql = "insert into post(post_description,post_title,registrationId,thumbnailImage) values('"+post.getPost_description()+"','"+post.getPost_title()+"',"+post.getRegistrationId()+",'"+post.getFile().getOriginalFilename()+"')";
			int status = stmt.executeUpdate(sql);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	public int updatePost(Post post) {
		// TODO Auto-generated method stub
		Connection con = dbcon.getConnection();
		
		   try {
			Statement stmt   = con.createStatement();
			String sql = "update  post set post_description = '"+post.getPost_description()+"', post_title ='"+post.getPost_title()+"' where post_id = "+ post.getPost_id()+"";
			int status = stmt.executeUpdate(sql);
			//System.out.println(status);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int deletepost(Post post) {
		// TODO Auto-generated method stub
		Connection con = dbcon.getConnection();
		
		   try {
			Statement stmt   = con.createStatement();
			String sql = "delete from post where post_id = "+ post.getPost_id()+"";
			int status = stmt.executeUpdate(sql);
			//System.out.println(status);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public List<Post> allPost() {
		// TODO Auto-generated method stub
		
		Connection con = dbcon.getConnection();
		List<Post> list = new ArrayList<Post>();
		try {
			Statement stmt= con.createStatement();
			String sql = "select *from post";
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Post x = new Post();
				x.setPost_id(Integer.parseInt(rs.getString(1)));
				x.setPost_description(rs.getString(2));
				x.setPost_title(rs.getString(4));
				list.add(x);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	

	
	
	
}
