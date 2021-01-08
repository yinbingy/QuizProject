package com.yby.demo.dao.imp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import com.yby.demo.dao.UserDAO;
import com.yby.demo.domain.Feedback;
import com.yby.demo.domain.User;
import com.yby.demo.util.HibernateConfigUtil;



public class UserHibernateDAO implements UserDAO{

	

	@Override
	public String addUser(String name, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			
			User e2 = new User();
			e2.setUser_name(name);
			e2.setPwd(pwd);
			
			User e1 = (User) session.merge(e2);
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
		return "Seccuess";
	}

	@Override
	public User getUserByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();

			Query query=session.createSQLQuery("select * from user where USER_NAME= :idVal")  
				    .addEntity(User.class);  
				query.setString("idVal", name);//设置查询条件  
			List<User> result = query.list();  
			
			
				
			transaction.commit();
			if (result != null) {
				return result.get(0);
			}
				
			
						
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	
		return null;
		
	}

	@Override
	public User getUser(String name, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		Session session = HibernateConfigUtil.openSession();
		Transaction transaction = null;

		try {
			transaction = session.beginTransaction();
			
			Query query=session.createSQLQuery("select * from user where USER_NAME= :nameVal and PWD = :pwdVal")  
				    .addEntity(User.class);  
				query.setString("nameVal", name);//设置查询条件  
				query.setString("pwdVal", pwd);
			List<User> result = query.list();  
			
			
			transaction.commit();
			if (result != null) {
				if(result.size() != 0) {
					return result.get(0);
				}
				
			} 
						
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			session.close();
		}
	
		return null;
	}

}
