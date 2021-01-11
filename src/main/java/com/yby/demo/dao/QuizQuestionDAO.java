package com.yby.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.yby.demo.domain.QuizQuestion;
import com.yby.demo.util.JDBCUtil;

public interface QuizQuestionDAO {
	
	public List<QuizQuestion> getAllQuizQuestionByType(int tpyeId) throws SQLException;

	public List<QuizQuestion> getAllQuizQuestionByTypeWithDisabled(int tpyeId) throws SQLException;

	
	public boolean updateStatus(int id, Boolean b) throws SQLException;
}
