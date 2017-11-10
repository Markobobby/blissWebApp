package com.blissWebApp.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import com.blissWebApp.dao.MachineDAO;
import com.blissWebApp.dao.SalleDAO;
import com.blissWebApp.db.HibernateUtil;
import com.blissWebApp.metier.Machine;
import com.blissWebApp.metier.Salle;

@WebServlet("/ajaxRequest/*")
public class ServletAjaxRequest extends UtilHttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void monitoringmachine(){
		int idSalle = this.getParamAsInt("idSalle");
		List<Machine> machines = MachineDAO.getMachineListBySalle(idSalle);
		for(int i=0; i<machines.size(); i++){
			Date date = new Date();
			long time = date.getTime()/1000;
			System.out.println(time);
			int d = Integer.parseInt( machines.get(i).getDateDernierRecut() );
			time = time - d;
			machines.get(i).setDateDernierRecut(String.valueOf(time));
		}
		this.displayView(machines);
	}
}
