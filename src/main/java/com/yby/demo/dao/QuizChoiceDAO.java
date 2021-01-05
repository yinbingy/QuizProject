package com.yby.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yby.demo.domain.QuizChoice;
import com.yby.demo.util.JDBCUtil;

public class QuizChoiceDAO {
	
	public List<QuizChoice> getAllQuizChoiceByQuestionId(int questionId) throws SQLException {
		List<QuizChoice> qcList = new ArrayList<>();
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM choice as ch WHERE ch.QUESTION_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, questionId);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			QuizChoice qc = new QuizChoice();
			qc.setChoice_id(rs.getInt("CHOICE_ID"));
			qc.setQuestion_id(rs.getInt("QUESTION_ID"));
			qc.setContent(rs.getString("CONTENT"));
			qc.setIf_correct(rs.getBoolean("IF_CORRECT"));
			
			qcList.add(qc);
		}
		
		
		return qcList;
		
	}
	
	public QuizChoice getQuizChoiceByChoiceId(int choiceId) throws SQLException {
		
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM choice as ch WHERE ch.CHOICE_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, choiceId);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			QuizChoice qc = new QuizChoice();
			qc.setChoice_id(rs.getInt("CHOICE_ID"));
			qc.setQuestion_id(rs.getInt("QUESTION_ID"));
			qc.setContent(rs.getString("CONTENT"));
			qc.setIf_correct(rs.getBoolean("IF_CORRECT"));
			return qc;
		} else {
			return null;
		}
		
	}
	
	public boolean getCorrectByChoiceId(int choiceId) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT * FROM choice as ch WHERE ch.CHOICE_ID = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, choiceId);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			return rs.getBoolean("IF_CORRECT");
		} else {
			return false;
		}
		
	}

}
