package com.yby.demo.dao;

import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yby.demo.domain.Feedback;
import com.yby.demo.util.HibernateConfigUtil;


public class FeedBackHibernateDAO implements FeedBackDAO {
	
	

	@Override
	public boolean addFeedBack(String content, int star) throws SQLException {
		// TODO Auto-generated method stub
		
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			
			
			
			Feedback e2 = new Feedback();
			e2.setFeedbackContent(content);
			e2.setFeedbackStar(star);
			
			Feedback e1 = (Feedback) session.merge(e2);
			System.out.println(e1);
			transaction.commit();
			
		} catch (Exception e) {
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
