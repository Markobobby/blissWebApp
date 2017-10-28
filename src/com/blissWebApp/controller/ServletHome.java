package com.blissWebApp.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.blissWebApp.dao.SalleDAO;
import com.blissWebApp.metier.Salle;

@WebServlet("/home/*")
public class ServletHome extends UtilHttpServlet {
	// UserDAO userDao;
	SalleDAO salleDao;
	
	private static final long serialVersionUID = 1L;
	
    public void index(){
    	List<Salle> salle= SalleDAO.getSalleList();
    	this.displayView(salle);
    }
    public void connexion(){
    	this.displayView(null);
    }
    public void managementmachine(){
    	this.displayView(null);
    }
    public void managementroom(){
    	this.displayView(null);
    }
}
