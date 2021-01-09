package com.yby.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yby.demo.domain.QuizResult;
import com.yby.demo.util.JDBCUtil;

public interface ResultDAO {
	
	public boolean addResult(QuizResult quizResult) throws SQLException;

}
