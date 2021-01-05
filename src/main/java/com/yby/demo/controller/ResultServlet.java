package com.yby.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
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
import com.yby.demo.dao.ResultDAO;
import com.yby.demo.domain.QuizChoice;
import com.yby.demo.domain.QuizQuestion;
import com.yby.demo.domain.QuizQuestionWithCorrect;
import com.yby.demo.domain.QuizResult;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet{
	
	private QuizChoiceDAO quizChoiceDao;
	private ResultDAO resultDao;
	
	@Override
	public void init() {
		quizChoiceDao = new QuizChoiceDAO();
		resultDao = new ResultDAO();
	}
//	
	
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
		
		
		
		Map<Integer, Integer> choiceIdUserMade = (Map<Integer, Integer>) request.getAttribute("choiceUserMade");
		
		List<QuizQuestion> qqList = new ArrayList<>();
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.setAttribute("loginMsg", "Timeout!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		qqList = (List<QuizQuestion>) session.getAttribute("QuizeQuestionList");
		
		
		int correctNum = 0;
		List<QuizQuestionWithCorrect> qqwcList = new ArrayList<>();
		for(QuizQuestion qq : qqList) {
			if (choiceIdUserMade.containsKey(qq.getQuiz_question_id())) {
				
				int cId = choiceIdUserMade.get(qq.getQuiz_question_id());
				
				QuizChoice qc = null;
				try {
					qc = quizChoiceDao.getQuizChoiceByChoiceId(cId);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if( qc.isIf_correct()) {
					correctNum += 1;
				}
				QuizQuestionWithCorrect qqwc =new QuizQuestionWithCorrect();
				qqwc.setqContent(qq.getContent());
				qqwc.setcContent(qc.getContent());
				qqwc.setIfCorrect(qc.isIf_correct());
				
				qqwcList.add(qqwc);
				
				
			} else {
				QuizQuestionWithCorrect qqwc =new QuizQuestionWithCorrect();
				qqwc.setqContent(qq.getContent());
				qqwc.setcContent("N/A");
				qqwc.setIfCorrect(false);
				qqwcList.add(qqwc);
			}
		}
		
		int numOfQuestions = qqList.size();
		float avg = (float) (correctNum) / (float) (numOfQuestions);
		
		if (avg >= 0.8) {
			request.setAttribute("pass", "You passed it!");
		} else {
			request.setAttribute("pass", "You failed it!");
		}
		
		
		QuizResult qr = new QuizResult();
		qr.setUserId((int) session.getAttribute("UserId"));
		qr.setTypeId((int) session.getAttribute("typeId"));
		
		qr.setScore((int) avg);
		qr.setStartTime((Timestamp)session.getAttribute("startTime"));
		qr.setEndTime((Timestamp)session.getAttribute("endTime"));
		
		
		try {
			resultDao.addResult(qr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("numOfQuestions", numOfQuestions);
		request.setAttribute("correctNum", correctNum);
		request.setAttribute("qqwcList", qqwcList);
	
		request.getRequestDispatcher("result.jsp").forward(request, response);   
		

		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			request.setAttribute("loginMsg", "Timeout!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		session.removeAttribute("QuizPage");
		session.removeAttribute("QuizeQuestionList");
		session.removeAttribute("choiceUserMade");
		session.removeAttribute("questionSize");
		session.removeAttribute("startTime");
		session.removeAttribute("endTime");
		request.getRequestDispatcher("/HomeServlet").forward(request, response);
		
		
	}

}
