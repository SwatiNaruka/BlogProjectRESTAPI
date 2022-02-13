package com.Question3.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Question3.model.Comments;

@Repository
public class CommentsDao {

	@Autowired
	DbConnection dbcon;
	
	public int sendComment(Comments com) {
		// TODO Auto-generated method stub
		Connection con = dbcon.getConnection();
		
		   try {
			Statement stmt   = con.createStatement();
			String sql = "insert into comments(commentDetail,registrationId,post_id) values('"+com.getComments()+"',"+com.getRegistar_id()+","+com.getPost_id()+")";
			int status= stmt.executeUpdate(sql);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}

	public int deleteComment(Comments coment) {
		// TODO Auto-generated method stub
		Connection con = dbcon.getConnection();
		
		   try {
			Statement stmt   = con.createStatement();
			String sql = "delete from comments where comment_id = "+coment.getComment_id()+"";
			int status= stmt.executeUpdate(sql);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public int updateComments(Comments c) {
		// TODO Auto-generated method stub
		Connection con = dbcon.getConnection();
		
		   try {
			Statement stmt   = con.createStatement();
		//	String sql = "update comments set commentDetail  = '"+c.getComments()+"' where comment_id = "+c.getComment_id()+"";
			String sql = " update comments set commentDetail = '"+c.getComments()+"' where comment_id= "+c.getComment_id()+"";
			int status= stmt.executeUpdate(sql);
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	public List<Comments> findComment() {
		// TODO Auto-generated method stub
		Connection con = dbcon.getConnection();
		List<Comments> list = new ArrayList<Comments>();
		   try {
			Statement stmt   = con.createStatement();
			String sql = "select * from comments";
			ResultSet rs= stmt.executeQuery(sql);
			while(rs.next()) {
				Comments com = new Comments();
				com.setRegistar_id(Integer.parseInt(rs.getString(1)));
				com.setPost_id(Integer.parseInt(rs.getString(2)));
				com.setComment_id(Integer.parseInt(rs.getString(3)));
				com.setComments(rs.getString(4));
				list.add(com);
				
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		   return list;
	}

}
