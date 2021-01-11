package com.yby.demo.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yby.demo.dao.QuizQuestionDAO;
import com.yby.demo.domain.QuizQuestion;
import com.yby.demo.domain.QuizType;
import com.yby.demo.util.JDBCUtil;

public class QuizQuestionJDBCDAO implements QuizQuestionDAO{
	
	private QuizTypeJDBCDAO dao;
	
	public QuizQuestionJDBCDAO(){
		dao = new QuizTypeJDBCDAO();
	}
	
	
	public List<QuizQuestion> getAllQuizQuestionByType(int tpyeId) throws SQLException {
		List<QuizQuestion> question_list = new ArrayList<>();
		
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM quiz_question WHERE QUIZ_TYPE_ID = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, tpyeId);
		
		ResultSet rs = ps.executeQuery();
		
		QuizType qt = dao.selectById(tpyeId);
		
		
		while (rs.next()) {
			QuizQuestion qq = new QuizQuestion();
			qq.setQuiz_question_id(rs.getInt("QUIZ_QUESTION_ID"));
			qq.setQuiz_type(qt);
			qq.setContent(rs.getString("CONTENT"));
			
			question_list.add(qq);

		}
		return question_list;
		
	}


	@Override
	public boolean updateStatus(int id, Boolean b) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public List<QuizQuestion> getAllQuizQuestionByTypeWithDisabled(int tpyeId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public boolean updateContent(int id, String content) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}