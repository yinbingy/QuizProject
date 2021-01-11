package com.yby.demo.dao.imp;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import com.yby.demo.dao.QuizQuestionDAO;
import com.yby.demo.domain.QuizQuestion;
import com.yby.demo.domain.QuizResult;
import com.yby.demo.domain.QuizType;
import com.yby.demo.domain.User;
import com.yby.demo.util.HibernateConfigUtil;

public class QuizQuestionHibernateDAO implements QuizQuestionDAO {

	@Override
	public List<QuizQuestion> getAllQuizQuestionByType(int tpyeId) throws SQLException {
		
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;
		List<QuizQuestion> quizQuestionList = null;
		try {
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<QuizQuestion> criteriaQuery = cb.createQuery(QuizQuestion.class);
			Root<QuizQuestion> root = criteriaQuery.from(QuizQuestion.class);

		
			quizQuestionList = session.createQuery("from QuizQuestion where quiz_type_id = :idVal and status = 1 order by rand()").setInteger("idVal", tpyeId).setMaxResults(10).getResultList();

			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return quizQuestionList;
	}

	@Override
	public boolean updateStatus(int id, Boolean b) throws SQLException {
		// TODO Auto-generated method stub
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			QuizQuestion question = session.get(QuizQuestion.class, id);
			
			question.setStatus(b);
			

			session.merge(question);
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		
		return true;
	}

	@Override
	public List<QuizQuestion> getAllQuizQuestionByTypeWithDisabled(int tpyeId) throws SQLException {
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;
		List<QuizQuestion> quizQuestionList = null;
		try {
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<QuizQuestion> criteriaQuery = cb.createQuery(QuizQuestion.class);
			Root<QuizQuestion> root = criteriaQuery.from(QuizQuestion.class);

		
			quizQuestionList = session.createQuery("from QuizQuestion where quiz_type_id = :idVal").setInteger("idVal", tpyeId).getResultList();

			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return quizQuestionList;
	}

	@Override
	public boolean updateContent(int id, String content) throws SQLException {
		// TODO Auto-generated method stub
				Session session = HibernateConfigUtil.openSession();
				Transaction transaction = null;
				try {
					transaction = session.beginTransaction();
					
					QuizQuestion question = session.get(QuizQuestion.class, id);
					
					question.setContent(content);
					

					session.merge(question);
					transaction.commit();
					
				} catch (Exception e) {
					if (transaction != null) {
						transaction.rollback();
					}
					e.printStackTrace();
					return false;
				} finally {
					session.close();
				}
				
				return true;
	}

	@Override
	public int addQuestion(QuizQuestion q) throws SQLException {
		
		
		
		// TODO Auto-generated method stub
				Session session = HibernateConfigUtil.openSession();
				Transaction transaction = null;
				
				try {
					transaction = session.beginTransaction();
					QuizQuestion result = (QuizQuestion) session.merge(q);
					transaction.commit();
					
					return result.getQuiz_question_id();
				} catch(Exception e) {
					if (transaction != null) {
						transaction.rollback();
					}
					
					e.printStackTrace();
				} finally {
					session.close();
				}
				return 0;
	}
	
	


}
