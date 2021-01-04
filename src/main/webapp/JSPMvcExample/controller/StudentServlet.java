package com.bfs.JSPMvcExample.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bfs.JSPMvcExample.dao.StudentDAO;
import com.bfs.JSPMvcExample.domain.Student;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDAO studentDAO;
	
	public StudentServlet() {
		studentDAO = new StudentDAO();
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if ("list".equalsIgnoreCase(action)) {		
			List<Student> students = studentDAO.getAllStudents();
			request.setAttribute("students", students);
			request.getRequestDispatcher("student.jsp").forward(request, response);
		} else {
			throw new NullPointerException("Exception occurred during processing!");
		}
	}

}
