package com.blissWebApp.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.blissWebApp.db.HibernateUtil;
import com.blissWebApp.metier.Salle;

public class SalleDAO {
	public static List<Salle> getSalleList(){
		try{
			Query q;
			q = HibernateUtil.getSession().createQuery("from Salle");
			
			List<Salle> listeSalle= q.list();
			return (listeSalle);
		}catch(Exception e){
			return null;
		}
	}
}
