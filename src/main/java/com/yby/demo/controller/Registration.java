package com.yby.demo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yby.demo.dao.UserDAO;

@WebServlet("/RegistrationServlet")
public class Registration extends HttpServlet{
	
	private UserDAO userDao;
	
	@Override
	public void init() {
		userDao = new UserDAO();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String username = req.getParameter("name");
		String password = req.getParameter("password");
		
		
		String registerMsg = null;
		if (username != null && !username.equals("") && password != null && !password.equals(""))
		{
			try {
				registerMsg = userDao.addUser(username, password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			registerMsg ="Username or password cannot be empty.";
		}
		
		if (registerMsg.equals("Seccuess")) {
			req.setAttribute("loginMsg", "Sign up seccuess");
			req.getRequestDispatcher("/login.jsp").forward(req, resp);
			
		} else {
			req.setAttribute("registerMsg", registerMsg);
			req.getRequestDispatcher("/registration.jsp").forward(req, resp);
		}
		
		
		
		
	}

}
