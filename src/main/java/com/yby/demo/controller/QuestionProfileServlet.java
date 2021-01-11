package com.yby.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yby.demo.dao.DAOFactory;
import com.yby.demo.dao.QuizQuestionDAO;
import com.yby.demo.dao.QuizTypeDAO;
import com.yby.demo.domain.QuizQuestion;
import com.yby.demo.domain.QuizType;
import com.yby.demo.domain.User;

@WebServlet("/QuestionProfileServlet")
public class QuestionProfileServlet extends HttpServlet{
	
	
	private QuizQuestionDAO qqDao;
	private QuizTypeDAO qtDao;
	
	@Override
	public void init() {
		qqDao = DAOFactory.createQuizQuestionDAO("Hibernate");
		qtDao = DAOFactory.createQuizTypeDAO("Hibernate");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<QuizType> typeList = null;
		try {
			typeList = qtDao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session = request.getSession(false);
		
		session.setAttribute("typeList", typeList);
		request.getRequestDispatcher("/questionProfile.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getParameter("show") != null) {
			int typeid = Integer.parseInt(request.getParameter("show"));
			HttpSession session = request.getSession(false);
			session.setAttribute("typeid", typeid);
			
			
		} else if (request.getParameter("disable") != null ) {
			int id = Integer.parseInt(request.getParameter("disable"));
			
			try {
				qqDao.updateStatus(id, false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} else if (request.getParameter("enable") != null) {
			int id = Integer.parseInt(request.getParameter("enable"));
			
			try {
				qqDao.updateStatus(id, true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (request.getParameter("update") != null) {
			String s = request.getParameter("content");
			int id = Integer.parseInt(request.getParameter("update"));
			try {
				qqDao.updateContent(id, s);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		HttpSession session = request.getSession(false);
		int typeid = (int) session.getAttribute("typeid");
		List<QuizQuestion> quizList = null;
		try {
			quizList = qqDao.getAllQuizQuestionByTypeWithDisabled(typeid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		request.setAttribute("questionList", quizList);
		request.getRequestDispatcher("/questionProfile.jsp").forward(request, response);
		
		
		
	}
	
	
	

}
