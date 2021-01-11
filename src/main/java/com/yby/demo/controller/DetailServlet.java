package com.yby.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yby.demo.dao.DAOFactory;
import com.yby.demo.dao.QuizChoiceDAO;
import com.yby.demo.dao.QuizDetailDAO;
import com.yby.demo.dao.ResultDAO;
import com.yby.demo.domain.QuizChoice;
import com.yby.demo.domain.QuizDetail;
import com.yby.demo.domain.QuizResult;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet{
	private ResultDAO resultDao;
	private QuizDetailDAO quizDao;
	private QuizChoiceDAO cDao;
	
	@Override
	public void init() {
		resultDao = DAOFactory.createResultDAO("Hibernate");
		quizDao = DAOFactory.createQuizDetailtDAO("Hibernate");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		int resultId = Integer.parseInt( req.getParameter("resultId"));
		List<QuizDetail> qdList = quizDao.selectQuizDetailByResultId(resultId);
		
		req.setAttribute("qdList", qdList);
		req.getRequestDispatcher("detail.jsp").forward(req, resp);		
		
	}
	

}

