package com.yby.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yby.demo.util.JDBCUtil;

public class FeedBackDAO {
	
	
	
	public boolean addFeedBack(String content, int star) throws SQLException {
		Connection conn = JDBCUtil.getConnection();
		String sql = "INSERT INTO feedback(FEEDBACK_CONTENT, FEEDBACK_STAR) value (?, ?)";
		
		
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, content);
		ps.setInt(2, star);
		
		int i = ps.executeUpdate();
		
		if(i == 0) {
			return false;
		} else {
			return true;
		}
	}

}
