package com.yby.demo.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;
import com.yby.demo.dao.QuizChoiceDAO;
import com.yby.demo.dao.QuizQuestionDAO;
import com.yby.demo.dao.QuizTypeDAO;
import com.yby.demo.domain.QuizChoice;
import com.yby.demo.domain.QuizQuestion;

@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet{
	


	
	private QuizQuestionDAO qqDao;
	private QuizChoiceDAO qcDao;
	
	//private Map<Integer, Integer> choiceUserMade;
	
	
	@Override
	public void init() {
		qqDao = new QuizQuestionDAO();
		qcDao = new QuizChoiceDAO();
		//choiceUserMade = new HashMap<>();
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		String jump = request.getParameter("jump");
		String act = request.getParameter("act");
		if (jump != null) {
			
			
			HttpSession session = request.getSession(false);
			if(session == null) {
				request.setAttribute("loginMsg", "Timeout!");

				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			int i = Integer.parseInt(jump) - 1;
			
			Map<Integer, Integer> choiceUserMade = (Map<Integer, Integer>) session.getAttribute("choiceUserMade");
			
			List<QuizQuestion> qqList = (List<QuizQuestion>)session.getAttribute("QuizeQuestionList");
			
			
//			if(request.getParameter("choiceSelected") != null) {
//				int choiceId = Integer.parseInt(request.getParameter("choiceSelected"));
//				choiceUserMade.put(qqList.get(i).getQuiz_question_id(), choiceId);
//			}
			
			QuizQuestion qq = qqList.get(i);
			
			
			
			List<QuizChoice> qcList = null;
			
			try {
				qcList = qcDao.getAllQuizChoiceByQuestionId(qq.getQuiz_question_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("QuizChoiceList", qcList);
			
			int nextChoiceId = 0;
			
			
			if (choiceUserMade.containsKey(qq.getQuiz_question_id())) {
				nextChoiceId = choiceUserMade.get(qq.getQuiz_question_id());
			}
			
			request.setAttribute("nextChoiceId", nextChoiceId);
			session.setAttribute("quizPage", i);
			request.getRequestDispatcher("question.jsp").forward(request, response);
			
		    
		} else if (act.equals("next")) {
			
			HttpSession session = request.getSession(false);
			if(session == null) {
				request.setAttribute("loginMsg", "Timeout!");

				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			int i = (int) session.getAttribute("quizPage");
			
			Map<Integer, Integer> choiceUserMade = (Map<Integer, Integer>) session.getAttribute("choiceUserMade");
			
			List<QuizQuestion> qqList = (List<QuizQuestion>)session.getAttribute("QuizeQuestionList");
			
			
			if(request.getParameter("choiceSelected") != null) {
				int choiceId = Integer.parseInt(request.getParameter("choiceSelected"));
				choiceUserMade.put(qqList.get(i).getQuiz_question_id(), choiceId);
			}
			
			QuizQuestion qq = qqList.get(i+1);
			
			
			
			List<QuizChoice> qcList = null;
			
			try {
				qcList = qcDao.getAllQuizChoiceByQuestionId(qq.getQuiz_question_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("QuizChoiceList", qcList);
			
			int nextChoiceId = 0;
			
			if (choiceUserMade.containsKey(qq.getQuiz_question_id())) {
				nextChoiceId = choiceUserMade.get(qq.getQuiz_question_id());
			}
			
			request.setAttribute("nextChoiceId", nextChoiceId);
			session.setAttribute("quizPage", i+1);
			request.getRequestDispatcher("question.jsp").forward(request, response);
			
		} else if (act.equals("prev")) {
			
			HttpSession session = request.getSession(false);
			
			if(session == null) {
				request.setAttribute("loginMsg", "Timeout!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			int i = (int) session.getAttribute("quizPage");
			
			Map<Integer, Integer> choiceUserMade = (Map<Integer, Integer>) session.getAttribute("choiceUserMade");
			List<QuizQuestion> qqList = (List<QuizQuestion>)session.getAttribute("QuizeQuestionList");

			
			if(request.getParameter("choiceSelected") != null) {
				int choiceId = Integer.parseInt(request.getParameter("choiceSelected"));
				choiceUserMade.put(qqList.get(i).getQuiz_question_id(), choiceId);
			}
			QuizQuestion qq = qqList.get(i-1);
			List<QuizChoice> qcList = null;
			try {
				qcList = qcDao.getAllQuizChoiceByQuestionId(qq.getQuiz_question_id());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("QuizChoiceList", qcList);
			
			
			int nextChoiceId = 0;
			
			if (choiceUserMade.containsKey(qq.getQuiz_question_id())) {
				nextChoiceId = choiceUserMade.get(qq.getQuiz_question_id());
			}
			
			request.setAttribute("nextChoiceId", nextChoiceId);
			
			
			session.setAttribute("quizPage", i-1);
			request.getRequestDispatcher("question.jsp").forward(request, response);
		} else if (act.equals("submit")) {
			
			HttpSession session = request.getSession(false);
			if(session == null) {
				request.setAttribute("loginMsg", "Timeout!");

				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			int i = (int) session.getAttribute("quizPage");
			
			Map<Integer, Integer> choiceUserMade = (Map<Integer, Integer>) session.getAttribute("choiceUserMade");
			List<QuizQuestion> qqList = (List<QuizQuestion>)session.getAttribute("QuizeQuestionList");
			
			if(request.getParameter("choiceSelected") != null) {
				int choiceId = Integer.parseInt(request.getParameter("choiceSelected"));
				choiceUserMade.put(qqList.get(i).getQuiz_question_id(), choiceId);
			}
			
			
			
			if ( choiceUserMade.size() < qqList.size()) {
				
				
				QuizQuestion qq = qqList.get(i);
				List<QuizChoice> qcList = null;
				try {
					qcList = qcDao.getAllQuizChoiceByQuestionId(qq.getQuiz_question_id());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("QuizChoiceList", qcList);
				
				
				int nextChoiceId = 0;
				
				if (choiceUserMade.containsKey(qq.getQuiz_question_id())) {
					nextChoiceId = choiceUserMade.get(qq.getQuiz_question_id());
				}
				
				request.setAttribute("nextChoiceId", nextChoiceId);
				
				request.setAttribute("notFinish", true);
				request.getRequestDispatcher("question.jsp").forward(request, response);
			} else {
				
				request.setAttribute("choiceUserMade", choiceUserMade);
				
				session.setAttribute("endTime", new Timestamp(System.currentTimeMillis()));
				request.getRequestDispatcher("/ResultServlet").forward(request, response);
			}
			
		} else if (act.equals("force submit")){
			
			HttpSession session = request.getSession(false);
			if(session == null) {
				request.setAttribute("loginMsg", "Timeout!");

				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
			int i = (int) session.getAttribute("quizPage");
			
			Map<Integer, Integer> choiceUserMade = (Map<Integer, Integer>) session.getAttribute("choiceUserMade");
			List<QuizQuestion> qqList = (List<QuizQuestion>)session.getAttribute("QuizeQuestionList");
			
			if(request.getParameter("choiceSelected") != null) {
				int choiceId = Integer.parseInt(request.getParameter("choiceSelected"));
				choiceUserMade.put(qqList.get(i).getQuiz_question_id(), choiceId);
			}
			
				request.setAttribute("choiceUserMade", choiceUserMade);
				
				
				session.setAttribute("endTime", new Timestamp(System.currentTimeMillis()));
				request.getRequestDispatcher("/ResultServlet").forward(request, response);
			
		}
		else {
		    //someone has altered the HTML and sent a different value!
		}
		
		

		HttpSession session = request.getSession(false);
		if(session == null) {
			request.setAttribute("loginMsg", "Timeout!");

			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			
			System.out.println(session.getAttribute("choiceUserMade"));
		}
		
	}
	
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		String s = request.getParameter("quizId");
		
		if(s == null) {
			request.getRequestDispatcher("HomeServlet").forward(request, response);
		}
		String typeName = request.getParameter("quizType");
		List<QuizQuestion> qqList = new ArrayList<>();
		List<QuizChoice> qcList = new ArrayList<>();
		
		Map<Integer, Integer> choiceUserMade = new HashMap<>();
		
		
		
		try {
			qqList = qqDao.getAllQuizQuestionByType(Integer.parseInt(s));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		HttpSession session = request.getSession(false);		
		
		session.setAttribute("typeId", Integer.parseInt(s));
		session.setAttribute("choiceUserMade", choiceUserMade);
		session.setAttribute("QuizeQuestionList", qqList);
		session.setAttribute("quizPage", 0);
		session.setAttribute("questionSize", qqList.size());
		
		session.setAttribute("quizType", typeName);
		session.setAttribute("startTime", new Timestamp(System.currentTimeMillis()));
		QuizQuestion qq = qqList.get(0);
		
		try {
			qcList = qcDao.getAllQuizChoiceByQuestionId(qq.getQuiz_question_id());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("QuizChoiceList", qcList);
		
		request.getRequestDispatcher("question.jsp").forward(request, response);
		
		
		
	}
}
