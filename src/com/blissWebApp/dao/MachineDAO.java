package com.blissWebApp.dao;

import java.util.List;

import org.hibernate.query.Query;

import com.blissWebApp.db.HibernateUtil;
import com.blissWebApp.metier.Machine;


public class MachineDAO {
	public static List<Machine> getMachineListBySalle(int id){
		try{
			Query q;
			q = HibernateUtil.getSession().createQuery("from Machine where idSalle=?")
			.setParameter(0, id);
			List<Machine> listeMachine= q.list();
			return (listeMachine);
		}catch(Exception e){
			return null;
		}
	}
}
