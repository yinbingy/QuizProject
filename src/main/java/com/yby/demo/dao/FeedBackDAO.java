package com.yby.demo.dao;

import java.sql.SQLException;

public interface FeedBackDAO {
	public boolean addFeedBack(String content, int star) throws SQLException;
}
