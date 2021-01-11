package com.yby.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.yby.demo.domain.User;

public interface UserDAO {
	
	public List<User> selectAllUsers() throws SQLException;
	
	public String addUser(String name, String pwd) throws SQLException;
	
	public User getUserByName(String name) throws SQLException;
	
	public User getUser(String name, String pwd) throws SQLException;
	
	public boolean updateStatus(int id, Boolean b) throws SQLException;

}
