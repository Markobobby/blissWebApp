package com.blissWebApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import com.blissWebApp.dao.MachineDAO;
import com.blissWebApp.dao.SalleDAO;
import com.blissWebApp.metier.Machine;
import com.blissWebApp.metier.Salle;

@WebServlet("/home/*")
public class ServletHome extends UtilHttpServlet {
	// UserDAO userDao;
	SalleDAO salleDao;
	
	private static final long serialVersionUID = 1L;
	
    public void index(){
    	Map<String, Object> model = new HashMap<String, Object>();
    	List<Salle> salle= SalleDAO.getSalleList();
    	List<Machine> machine = null;
    	if(this.req.getMethod().equals("POST")){
    	machine = MachineDAO.getMachineListBySalle(Integer.parseInt(this.getParam("nomSalle")));
    	}
    	model.put("machine", machine);
    	model.put("salle", salle);
    	this.displayView(model);
    }
}
