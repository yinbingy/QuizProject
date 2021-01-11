package com.yby.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yby.demo.dao.DAOFactory;
import com.yby.demo.dao.UserDAO;
import com.yby.demo.domain.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	private UserDAO userDao;
	
	@Override
	public void init() {
		userDao = DAOFactory.createUserDAO("Hibernate");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		

		String username = request.getParameter("name");
		String password = request.getParameter("password");
		
		User user = null;
		try {
			user = userDao.getUser(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if( (user == null) || (user.getUser_id() == null) ) {
			System.out.println("WRONG");
			request.setAttribute("loginMsg", "Wrong passward or name, try again!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			
			if (user.getStatus() == false) {
				System.out.println("Disable");
				request.setAttribute("loginMsg", "Your account has been disabled");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			
			HttpSession oldSession = request.getSession(false);
			if (oldSession != null) {
				oldSession.invalidate();
			}
			
			HttpSession newSession = request.getSession();
			newSession.setAttribute("sessionName", username);
			newSession.setAttribute("UserId", user.getUser_id());
			
			// set something
			newSession.setMaxInactiveInterval(5 * 60);

			
			
			
			System.out.println("Success");
			request.setAttribute("user", user);

			request.getRequestDispatcher("/HomeServlet").forward(request, response);
		}
		
		System.out.println(username + " " + password);
		
	

		
	}
	

}
