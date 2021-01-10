package com.yby.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.yby.demo.domain.QuizResult;
import com.yby.demo.util.JDBCUtil;

public interface ResultDAO {
	
	public int addResult(QuizResult quizResult) throws SQLException;
	
	public List<QuizResult> selectAllResult() throws SQLException;

}
