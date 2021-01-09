package com.yby.demo.dao.imp;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yby.demo.dao.QuizChoiceDAO;
import com.yby.demo.domain.QuizChoice;
import com.yby.demo.util.HibernateConfigUtil;

public class QuizChoiceHibernateDAO implements QuizChoiceDAO{

	@Override
	public List<QuizChoice> getAllQuizChoiceByQuestionId(int questionId) throws SQLException {
		Session session = HibernateConfigUtil.openSession();
		List<QuizChoice> choiceList = null;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<QuizChoice> cq = cb.createQuery(QuizChoice.class); 
			Root<QuizChoice> root = cq.from(QuizChoice.class);
			
			cq.select(root);
			
			Predicate predicate = root.get("question_id").in(questionId);
			
			cq.where(predicate);
			
			choiceList = session.createQuery(cq).getResultList();

			transaction.commit();
			
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return choiceList;
	}

	@Override
	public QuizChoice getQuizChoiceByChoiceId(int choiceId) throws SQLException {
		Session session = HibernateConfigUtil.openSession();
		List<QuizChoice> choiceList = null;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<QuizChoice> cq = cb.createQuery(QuizChoice.class); 
			Root<QuizChoice> root = cq.from(QuizChoice.class);
			
			cq.select(root);
			
			Predicate predicate = root.get("choice_id").in(choiceId);
			
			cq.where(predicate);
			
			choiceList = session.createQuery(cq).getResultList();

			transaction.commit();
			
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		if (choiceList != null) {
			return choiceList.get(0);
		} else {
			return null;
		}
		
	}

	@Override
	public boolean getCorrectByChoiceId(int choiceId) throws SQLException {
		Session session = HibernateConfigUtil.openSession();
		List<QuizChoice> choiceList = null;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<QuizChoice> cq = cb.createQuery(QuizChoice.class); 
			Root<QuizChoice> root = cq.from(QuizChoice.class);
			
			cq.select(root);
			
			Predicate predicate = root.get("choice_id").in(choiceId);
			
			cq.where(predicate);
			
			choiceList = session.createQuery(cq).getResultList();

			transaction.commit();
			
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		if (choiceList != null) {
			return choiceList.get(0).isIf_correct();
		} else {
			return false;
		}
		
	}
	
	public static void main (String [] args) {
		QuizChoiceHibernateDAO dao = new QuizChoiceHibernateDAO();
		
		try {
			System.out.println(dao.getAllQuizChoiceByQuestionId(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(dao.getQuizChoiceByChoiceId(13).getQuizQuestion().getContent());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(dao.getCorrectByChoiceId(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
