package com.blissWebApp.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.blissWebApp.db.HibernateUtil;
import com.blissWebApp.metier.Historique;

public class HistoDAO {	
	public static List<Historique> getHistoriqueList(){
		try{
			Query q;
			q = HibernateUtil.getSession().createQuery("from Historique");
			List<Historique> listeHistorique= q.list();
			if(HibernateUtil.getSession().isOpen())
				HibernateUtil.getSession().close();
			return listeHistorique;
		}catch(Exception e){
			return null;
		}
	}
}
