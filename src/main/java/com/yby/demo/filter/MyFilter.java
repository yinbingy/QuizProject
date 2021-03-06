package com.yby.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

@WebFilter(filterName="MyFilter", urlPatterns= {"/HomeServlet", "/QuizServlet", "/FeedbackServlet", "/ResultServlet", "/AdmainServlet", "/DetailServlet","/QuestionProfileServlet" , "/AddQuestionServlet", "/UserProfileServlet"})
public class MyFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response,FilterChain chain) 
	                   throws IOException, ServletException {
    	
	
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession(false);
		System.out.println("IN filter");
		
		if (session == null || session.getAttribute("sessionName") == null) {
			
			request.setAttribute("loginMsg", "Unauthorized access");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		} else {
			System.out.println(session.getAttribute("sessionName"));
			chain.doFilter(request, response);
		}          
	}  

}
