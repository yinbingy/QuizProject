package com.yby.demo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yby.demo.domain.QuizType;
import com.yby.demo.util.JDBCUtil;

public interface QuizTypeDAO {
	
	public List<QuizType> selectAll() throws SQLException;
	

}
