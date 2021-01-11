package com.yby.demo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yby.demo.dao.DAOFactory;
import com.yby.demo.dao.QuizChoiceDAO;
import com.yby.demo.dao.QuizQuestionDAO;
import com.yby.demo.dao.QuizTypeDAO;
import com.yby.demo.dao.ResultDAO;
import com.yby.demo.domain.QuizChoice;
import com.yby.demo.domain.QuizQuestion;
import com.yby.demo.domain.QuizResult;

@WebServlet("/AddQuestionServlet")
public class AddQuestionServlet extends HttpServlet{
	private QuizQuestionDAO quizDao;
	private QuizChoiceDAO choiceDao;
	
	@Override
	public void init() {
		quizDao = DAOFactory.createQuizQuestionDAO("Hibernate");
		choiceDao = DAOFactory.createQuizChoiceDAO("Hibernate");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		req.getRequestDispatcher("/addQuestion.jsp").forward(req, resp);
		

	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		HttpSession session = req.getSession(false);
		
		int typeId = (int) session.getAttribute("typeid");
		
		String content = req.getParameter("content");
		
		String choice1 = req.getParameter("choice1");
		
		String choice2 = req.getParameter("choice2");
		
		String choice3 = req.getParameter("choice3");
		
		QuizQuestion newQuestion = new QuizQuestion();
		newQuestion.setContent(content);
		newQuestion.setStatus(true);
		newQuestion.setQuiz_type_id(typeId);
		int qId = 0;
		try {
			qId = quizDao.addQuestion(newQuestion);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if(choice1 != null) {
			QuizChoice newChoice1 = new QuizChoice();
			newChoice1.setContent(choice1);
			newChoice1.setIf_correct(true);
			newChoice1.setQuestion_id(qId);
			
			try {
				choiceDao.addChoice(newChoice1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		if(choice2 != null && choice2 != "") {
			QuizChoice newChoice2 = new QuizChoice();
			newChoice2.setContent(choice2);
			newChoice2.setIf_correct(false);
			newChoice2.setQuestion_id(qId);
			
			try {
				choiceDao.addChoice(newChoice2);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(choice3 != null && choice3 != "") {
			QuizChoice newChoice3 = new QuizChoice();
			newChoice3.setContent(choice3);
			newChoice3.setIf_correct(false);
			newChoice3.setQuestion_id(qId);
			
			try {
				choiceDao.addChoice(newChoice3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		req.getRequestDispatcher("QuestionProfileServlet").forward(req, resp);;
		
		
		
		
		
		
		
		
		

	}

}
