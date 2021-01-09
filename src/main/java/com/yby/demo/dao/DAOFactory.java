package com.yby.demo.dao;

import com.yby.demo.dao.imp.FeedBackHibernateDAO;
import com.yby.demo.dao.imp.FeedBackJDBCDAO;
import com.yby.demo.dao.imp.QuizChoiceHibernateDAO;
import com.yby.demo.dao.imp.QuizChoiceJDBCDAO;
import com.yby.demo.dao.imp.QuizQuestionHibernateDAO;
import com.yby.demo.dao.imp.QuizQuestionJDBCDAO;
import com.yby.demo.dao.imp.QuizTypeHibernateDAO;
import com.yby.demo.dao.imp.QuizTypeJDBCDAO;
import com.yby.demo.dao.imp.ResultHibernateDAO;
import com.yby.demo.dao.imp.ResultJDBCDAO;
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
	
	public static QuizQuestionDAO createQuizQuestionDAO( String type) {
		switch(type) {
		case "JDBC":
			return new QuizQuestionJDBCDAO();
		case "Hibernate":
			return new QuizQuestionHibernateDAO();
		default:
			return new QuizQuestionHibernateDAO();
		
		}	
		
	}
	
	public static QuizChoiceDAO createQuizChoiceDAO( String type) {
		switch(type) {
		case  "JDBC":
			return new QuizChoiceJDBCDAO();
		
		
		case "Hibernate":
			return new QuizChoiceHibernateDAO();
		default:
			return new QuizChoiceHibernateDAO();
		}
	}
	
	public static ResultDAO createResultDAO (String type ) {
		switch(type) {
		case  "JDBC":
			return new ResultJDBCDAO();
		
		
		case "Hibernate":
			return new ResultHibernateDAO();
		default:
			return new ResultHibernateDAO();
		}
	}
	
	

}
