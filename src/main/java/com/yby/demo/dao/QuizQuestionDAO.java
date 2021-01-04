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

public class QuizQuestionDAO {
	
	public List<QuizQuestion> getAllQuizQuestionByType(int tpyeId) throws SQLException {
		List<QuizQuestion> question_list = new ArrayList<>();
		
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM quiz_question WHERE QUIZ_TYPE_ID = ?;";
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, tpyeId);
		
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			QuizQuestion qq = new QuizQuestion();
			qq.setQuiz_question_id(rs.getInt("QUIZ_QUESTION_ID"));
			qq.setQuiz_type_id(rs.getInt("QUIZ_TYPE_ID"));
			qq.setContent(rs.getString("CONTENT"));
			
			question_list.add(qq);

		}
		return question_list;
		
	}

}
