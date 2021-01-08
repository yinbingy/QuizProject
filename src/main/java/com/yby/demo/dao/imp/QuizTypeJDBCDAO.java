package com.yby.demo.dao.imp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.yby.demo.dao.QuizTypeDAO;
import com.yby.demo.domain.QuizType;
import com.yby.demo.util.JDBCUtil;

public class QuizTypeJDBCDAO  implements QuizTypeDAO{
	
	public List<QuizType> selectAll() throws SQLException {
		
		List<QuizType> return_list = new ArrayList<>();
		
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT * from quiz_type;";
		Statement stat = conn.createStatement();
		ResultSet rs = null;
		rs = stat.executeQuery(sql);
		
		
		while(rs.next()) {
			
			QuizType qt = new QuizType();
			qt.setType_id(rs.getInt("TYPE_ID"));
			qt.setType_name(rs.getString("TYPE_NAME"));
			return_list.add(qt);
		}
		
		rs.close();
		stat.close();
		conn.close();
		return return_list;
	}
	
	

}