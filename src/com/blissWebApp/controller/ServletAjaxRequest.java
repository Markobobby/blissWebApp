package com.blissWebApp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blissWebApp.dao.MachineDAO;
import com.blissWebApp.metier.Machine;

@WebServlet("/ajaxRequest/*")
public class ServletAjaxRequest extends UtilHttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void monitoringmachine(){
		System.out.println("Monitoring machine");
		int idSalle = this.getParamAsInt("idSalle");
		System.out.println(idSalle);
		List<Machine> machines = MachineDAO.getMachineListBySalle(idSalle);
		System.out.println(machines.get(0).getNomMachine());
		System.out.println(machines.get(0).isEtat());
		this.displayView(machines);
	}
}
