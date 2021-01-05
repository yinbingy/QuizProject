package com.yby.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yby.demo.domain.QuizResult;
import com.yby.demo.util.JDBCUtil;

public class ResultDAO {
	
	public boolean addResult(QuizResult quizResult) throws SQLException {
		
		
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO result(USER_ID, TYPE_ID, SCORE, START_TIME, END_TIME) value (?, ?, ?, ?, ?)";
		
		
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, quizResult.getUserId());
		
		ps.setInt(2, quizResult.getTypeId());
		ps.setInt(3, quizResult.getScore());
		ps.setTimestamp(4, quizResult.getStartTime());
		ps.setTimestamp(5, quizResult.getEndTime());
		
		
		
		int i = ps.executeUpdate();
		
		if(i == 0) {
			return false;
		} else {
			return true;
		}
	
	}

}
