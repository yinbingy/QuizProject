package com.yby.demo.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yby.demo.dao.QuizTypeDAO;
import com.yby.demo.domain.QuizType;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet{
	
	private QuizTypeDAO quizTypeDao;
	
	@Override
	public void init() {
		quizTypeDao = new QuizTypeDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<QuizType> quizTypeList = new ArrayList<>();
		try {
			quizTypeList = quizTypeDao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
		request.setAttribute("quizTypeList", quizTypeList);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<QuizType> quizTypeList = new ArrayList<>();
		try {
			quizTypeList = quizTypeDao.selectAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
		
		request.setAttribute("quizTypeList", quizTypeList);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		
		
	}
	
	
	

}
