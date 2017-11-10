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
			double number = Double.parseDouble(machines.get(i).getDisque());
			int aux = (int)(number*100);
			double result = aux/100d;
			machines.get(i).setDisque(new Double(result).toString());
			 number = Double.parseDouble(machines.get(i).getRam());
			 aux = (int)(number*100);
			result = aux/100d;
			machines.get(i).setRam(new Double(result).toString());
		}
		this.displayView(machines);
	}
}
