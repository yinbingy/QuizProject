package com.yby.demo.dao.imp;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.yby.demo.dao.QuizTypeDAO;
import com.yby.demo.domain.Feedback;
import com.yby.demo.domain.QuizType;
import com.yby.demo.util.HibernateConfigUtil;

public class QuizTypeHibernateDAO implements QuizTypeDAO{

	@Override
	public List<QuizType> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		
		
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;
		List<QuizType> allQuizType = null;
		try {
			transaction = session.beginTransaction();
			//CriteriaBuilder cb = session.getCriteriaBuilder();
			Query query = session.createQuery("from QuizType");
			allQuizType = query.list();
			
			
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return allQuizType;
	}
	
//	public static void main(String[] args) throws SQLException {
//		QuizTypeHibernateDAO dao = new QuizTypeHibernateDAO();
//		List<QuizType> qtypes = dao.selectAll();
//		System.out.println(qtypes.get(1).getQuiz_questions());
//		
//	}

}
