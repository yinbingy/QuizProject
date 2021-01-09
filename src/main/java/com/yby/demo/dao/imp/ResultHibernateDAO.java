package com.yby.demo.dao.imp;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yby.demo.dao.ResultDAO;
import com.yby.demo.domain.QuizResult;
import com.yby.demo.util.HibernateConfigUtil;

public class ResultHibernateDAO implements ResultDAO{

	@Override
	public boolean addResult(QuizResult quizResult) throws SQLException {
		// TODO Auto-generated method stub
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;
		
		try {
			transaction = session.beginTransaction();
			session.save(quizResult);
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
	

}
