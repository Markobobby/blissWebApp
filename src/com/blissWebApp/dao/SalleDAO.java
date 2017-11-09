package com.blissWebApp.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.blissWebApp.db.HibernateUtil;
import com.blissWebApp.metier.Salle;

public class SalleDAO {
	public static void Save(Salle s){
		HibernateUtil.getSession().saveOrUpdate(s);
		try{
			if(HibernateUtil.getSession().getTransaction().isActive())
				HibernateUtil.getSession().getTransaction().commit();
		}catch(Exception e){
			HibernateUtil.getSession().getTransaction().rollback();
			e.printStackTrace();
		}finally{
			if(HibernateUtil.getSession().isOpen())
				HibernateUtil.getSession().close();
		}
	}
	
	public static List<Salle> getSalleList(){
		try{
			Query q;
			q = HibernateUtil.getSession().createQuery("from Salle");
			List<Salle> listeSalle= q.list();
			if(HibernateUtil.getSession().isOpen())
				HibernateUtil.getSession().close();
			return (listeSalle);
		}catch(Exception e){
			return null;
		}
	}

	public static Salle getSalleByIdSalle(int idSalle) {
		try{
					Salle s = (Salle) HibernateUtil.getSession().createQuery("from Salle where idSalle=?")
					.setParameter(0, idSalle);
					if(HibernateUtil.getSession().isOpen())
						HibernateUtil.getSession().close();
					return s;
		}catch(Exception e){
			return null;
		}
	}
}
