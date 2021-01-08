package com.yby.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.yby.demo.domain.User;

public interface UserDAO {
	
	public String addUser(String name, String pwd) throws SQLException;
	
	public User getUserByName(String name) throws SQLException;
	
	public User getUser(String name, String pwd) throws SQLException;

}
