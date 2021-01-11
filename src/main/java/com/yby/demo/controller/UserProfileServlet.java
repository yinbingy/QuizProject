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
import com.yby.demo.dao.UserDAO;
import com.yby.demo.domain.QuizResult;
import com.yby.demo.domain.User;

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet{
	
	private UserDAO userDao;
	
	@Override
	public void init() {
		userDao = DAOFactory.createUserDAO("Hibernate");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		
		
		
		List<User> userList = null;
		try {
			userList = userDao.selectAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("userList", userList);
		
		req.getRequestDispatcher("/profile.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		
		if (req.getParameter("enable") != null) {
			int id = Integer.parseInt(req.getParameter("enable"));
			try {
				userDao.updateStatus(id, true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (req.getParameter("disable") != null) {
			int id = Integer.parseInt(req.getParameter("disable"));
			
			try {
				userDao.updateStatus(id, false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		List<User> userList = null;
		try {
			userList = userDao.selectAllUsers();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.setAttribute("userList", userList);
		
		req.getRequestDispatcher("/profile.jsp").forward(req, resp);
	}


}
