package com.yby.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yby.demo.domain.QuizChoice;
import com.yby.demo.util.JDBCUtil;

public interface QuizChoiceDAO {
	
	public List<QuizChoice> getAllQuizChoiceByQuestionId(int questionId) throws SQLException;
	
	public QuizChoice getQuizChoiceByChoiceId(int choiceId) throws SQLException;
	
	public boolean getCorrectByChoiceId(int choiceId) throws SQLException;

}
