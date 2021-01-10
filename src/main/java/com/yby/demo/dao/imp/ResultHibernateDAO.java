package com.yby.demo.dao.imp;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yby.demo.dao.ResultDAO;
import com.yby.demo.domain.QuizResult;
import com.yby.demo.util.HibernateConfigUtil;

public class ResultHibernateDAO implements ResultDAO{

	@Override
	public int addResult(QuizResult quizResult) throws SQLException {
		// TODO Auto-generated method stub
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			QuizResult result = (QuizResult) session.merge(quizResult);
			transaction.commit();
			
			return result.getResultId();
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

	@Override
	public List<QuizResult> selectAllResult() throws SQLException {
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;
		List<QuizResult> resultList = null;
		try {
			transaction = session.beginTransaction();
			resultList = session.createQuery("from QuizResult").getResultList();
			transaction.commit();
		} catch(Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return resultList;
	}
	
//	public static void main(String[] args) {
//		ResultHibernateDAO dao = new ResultHibernateDAO();
//		try {
//			List<QuizResult> ql = dao.selectAllResult();
//			System.out.println(ql);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
//	

}
