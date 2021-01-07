package com.yby.demo.dao;

public class DAOFactory {
	public static FeedBackDAO createFeedBackDAO( String feedBackType) {
		
		switch(feedBackType) {
		case "JDBC":
			return new FeedBackJDBCDAO();
		case "Hibernate":
			return new FeedBackHibernateDAO();
		default:
			return new FeedBackHibernateDAO();
		
		}	
	}

}
