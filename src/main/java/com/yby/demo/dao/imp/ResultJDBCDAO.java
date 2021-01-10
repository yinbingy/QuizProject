package com.yby.demo.dao.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.yby.demo.dao.ResultDAO;
import com.yby.demo.domain.QuizResult;
import com.yby.demo.util.JDBCUtil;

public class ResultJDBCDAO implements ResultDAO {
	public int addResult(QuizResult quizResult) throws SQLException {
		
		
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
			return 0;
		} else {
			return 1;
		}
	
	}

	@Override
	public List<QuizResult> selectAllResult() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<QuizResult> selectAllResult() throws SQLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
