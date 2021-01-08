package com.yby.demo.dao;

import com.yby.demo.dao.imp.FeedBackHibernateDAO;
import com.yby.demo.dao.imp.FeedBackJDBCDAO;
import com.yby.demo.dao.imp.QuizTypeHibernateDAO;
import com.yby.demo.dao.imp.QuizTypeJDBCDAO;
import com.yby.demo.dao.imp.UserHibernateDAO;
import com.yby.demo.dao.imp.UserJDBCDAO;

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
	
	public static UserDAO createUserDAO( String feedBackType) {
			
			switch(feedBackType) {
			case "JDBC":
				return new UserJDBCDAO();
			case "Hibernate":
				return new UserHibernateDAO();
			default:
				return new UserHibernateDAO();
			
			}	
		}
	

	public static QuizTypeDAO createQuizTypeDAO( String type) {
		
		switch(type) {
		case "JDBC":
			return new QuizTypeJDBCDAO();
		case "Hibernate":
			return new QuizTypeHibernateDAO();
		default:
			return new QuizTypeHibernateDAO();
		
		}	
		
	}
	
	

}
