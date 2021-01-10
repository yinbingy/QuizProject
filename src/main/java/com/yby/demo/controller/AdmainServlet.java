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
import com.yby.demo.dao.ResultDAO;
import com.yby.demo.dao.imp.ResultHibernateDAO;
import com.yby.demo.domain.QuizResult;


@WebServlet("/AdmainServlet")
public class AdmainServlet extends HttpServlet{
	private ResultDAO resultDao;
	
	@Override
	public void init() {
		resultDao = DAOFactory.createResultDAO("Hibernate");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		List<QuizResult> resultList = null;
		try {
			resultList= resultDao.selectAllResult();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("resultList", resultList);
		
		req.getRequestDispatcher("/admain.jsp").forward(req, resp);
	}
	

}
