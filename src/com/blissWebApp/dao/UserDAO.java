package com.blissWebApp.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.blissWebApp.db.HibernateUtil;
import com.blissWebApp.metier.User;
import com.blissWebApp.metier.Salle;

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
	/*
	public static List<Salle> getSalleList(){
		try{
			Query q;
			q = HibernateUtil.getSession().createQuery("from Salle");
			
			List<Salle> listeSalle= q.list();
			return (listeSalle);
		}catch(Exception e){
			return null;
		}
	}*/
}
