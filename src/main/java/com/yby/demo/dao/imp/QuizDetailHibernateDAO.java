package com.yby.demo.dao.imp;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yby.demo.dao.QuizDetailDAO;
import com.yby.demo.domain.QuizChoice;
import com.yby.demo.domain.QuizDetail;
import com.yby.demo.util.HibernateConfigUtil;

public class QuizDetailHibernateDAO implements QuizDetailDAO{



	@Override
	public List<QuizDetail> selectQuizDetailByResultId(int i) {
		Session session = HibernateConfigUtil.openSession();
		List<QuizDetail> quizList = null;
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<QuizDetail> cq = cb.createQuery(QuizDetail.class); 
			Root<QuizDetail> root = cq.from(QuizDetail.class);
			
			cq.select(root);
			
			Predicate predicate = root.get("resultId").in(i);
			
			cq.where(predicate);
			
			quizList = session.createQuery(cq).getResultList();

			transaction.commit();
			
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		return quizList;
	}

	@Override
	public boolean addQuizDetail(QuizDetail qd) {
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(qd);
			transaction.commit();
			
		} catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}
	
	public static void main(String[] args) {
		QuizDetailHibernateDAO dao = new QuizDetailHibernateDAO();
		List<QuizDetail> result = dao.selectQuizDetailByResultId(30);
		System.out.println(result.get(0));
	}

}
