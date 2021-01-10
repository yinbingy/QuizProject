package com.yby.demo.dao.imp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.yby.demo.dao.QuizDetailDAO;
import com.yby.demo.domain.QuizDetail;
import com.yby.demo.util.HibernateConfigUtil;

public class QuizDetailHibernateDAO implements QuizDetailDAO{



	@Override
	public List<QuizDetail> selectQuizDetailByResultId(int i) {
		// TODO Auto-generated method stub
		return null;
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

}
