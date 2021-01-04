package com.yby.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yby.demo.domain.User;
import com.yby.demo.util.*;
public class UserDAO {
	

	
	
	public ResultSet selectAll() throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT * from user;";
		Statement stat = conn.createStatement();
		ResultSet rs = null;
		rs = stat.executeQuery(sql);
		
		rs.close();
		stat.close();
		conn.close();
		return rs;
	}
	
	
	
	public String addUser(String name, String pwd) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		
		if(this.getUserByName(name).getUser_id() != null) {
			return "User Name exist, try another one";
		}
		
		
		String sql = "INSERT INTO user (USER_NAME, PWD) VALUE (?, ?);";
		
		PreparedStatement stat = conn.prepareStatement(sql);
		stat.setString(1, name);
		stat.setString(2, pwd);
		
		if(stat.executeUpdate() == 0) {
			return "Fail";
		}
		
		return "Seccuess";
	}
	
	
public User getUserByName(String name) throws SQLException {
		
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT * from user as u where u.USER_NAME = ?";
		
		
		PreparedStatement stat = conn.prepareStatement(sql);
		
		stat.setString(1, name);
		
		ResultSet rs = null;
		rs = stat.executeQuery();
		
		User u = new User();
		
		if(rs.next()) {
			u.setPwd(rs.getString("PWD"));
			u.setUser_id(rs.getInt("USER_ID"));
			u.setUser_name(rs.getString("USER_NAME"));
		}
		
		rs.close();
		stat.close();
		conn.close();
		
		return u;
		
	}
	
	public User getUser(String name, String pwd) throws SQLException {
		
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT * from user as u where u.USER_NAME = ? and u.PWD = ?";
		
		
		PreparedStatement stat = conn.prepareStatement(sql);
		
		stat.setString(1, name);
		stat.setString(2, pwd);
		
		ResultSet rs = null;
		rs = stat.executeQuery();
		
		User u = new User();
		
		if(rs.next()) {
			u.setPwd(rs.getString("PWD"));
			u.setUser_id(rs.getInt("USER_ID"));
			u.setUser_name(rs.getString("USER_NAME"));
		}
		
		rs.close();
		stat.close();
		conn.close();
		
		return u;
		
		
	}
	
	
	
	
	

}
