package com.blissWebApp.dao;

import com.blissWebApp.db.HibernateUtil;
import com.blissWebApp.metier.User;

public class UserDAO {
	public static void Save(User t){
		HibernateUtil.getSession().saveOrUpdate(t);
	}
	
	public static User getUserByMailPassword(String mail, String password){
		try{
		return (User) HibernateUtil.getSession()
			.createQuery("from User where mail=? and password=?")
			.setParameter(0, mail)
			.setParameter(1, password)
			.getSingleResult();
		}catch(Exception e){
			return null;
		}
	}
}
