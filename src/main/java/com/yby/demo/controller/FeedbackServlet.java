package com.yby.demo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yby.demo.dao.DAOFactory;
import com.yby.demo.dao.FeedBackDAO;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet{
	
	private FeedBackDAO feedbackDao;
	
	@Override
	public void init() {
		feedbackDao = DAOFactory.createFeedBackDAO("Hibernate");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String content = (String) req.getParameter("feedBack");
		String rate =  (String) req.getParameter("rating");
		
		
	
		int stars = Integer.parseInt(rate);
		
		try {
			feedbackDao.addFeedBack(content, stars);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("HomeServlet").forward(req, resp);
	}

}
