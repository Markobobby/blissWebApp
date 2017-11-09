package com.blissWebApp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.annotation.WebServlet;

import com.blissWebApp.dao.MachineDAO;
import com.blissWebApp.dao.SalleDAO;
import com.blissWebApp.dao.UserDAO;
import com.blissWebApp.metier.Machine;
import com.blissWebApp.metier.Salle;
import com.blissWebApp.metier.User;

@WebServlet("/home/*")
public class ServletHome extends UtilHttpServlet {
	UserDAO userDao;
	SalleDAO salleDao;
	MachineDAO machineDAO;
	
	private static final long serialVersionUID = 1L;
	
	public void index(){
		List<Salle> salles = SalleDAO.getSalleList();
		salles.remove(0);
		this.displayView(salles);
	}
    
  public void connexion(){
    if(this.req.getMethod().equals("POST")){
      String mail = getParam("mail");
      String password = getParam("pwd");
      User u = UserDAO.getUserByMailPassword(mail, password);
      if( u == null ){
        this.displayView(null);
        return;
      }else{
        this.req.getSession().setAttribute("USER", u);
        String redirect = (String) req.getSession().getAttribute("REDIRECT");
        if(redirect != null){
          try {
            this.resp.sendRedirect(redirect);
          } catch (Exception e) {
            e.printStackTrace();
          }
        }else redirect("/home/index");
      }
    }
    this.displayView(null);
  }
  
  public void managementmachine(){  	
  	List<Machine> machines = MachineDAO.getMachineListBySalle(1);
		List<Salle> salles = SalleDAO.getSalleList();
		salles.remove(0);
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("machines", machines);
		m.put("salles", salles);
		System.out.println("index");
  	this.displayView(m);
  }
  
//  public void managementroom(){
//  	List<Machine> machines = MachineDAO.getMachineListBySalle(1);
//  	List<Salle> salles = SalleDAO.getSalleList();
//  	Map<String, Object> m = new HashMap<String, Object>();
//  	m.put("machines", machines);
//  	m.put("salles", salles);
//  	System.out.println("index");
//  	this.displayView(m);
//  }
  
  public void logout(){
  	this.req.getSession().removeAttribute("USER");
  	redirect("/home/index");
  }
  
  public void ajoutsalle(){
		if(this.req.getMethod().equals("POST")){
			Salle s = new Salle();
			String nomSalle = this.getParam("nomSalle");
	  	s.setNomSalle(nomSalle);
	  	SalleDAO.Save(s);
	  	this.displayView(null);
		}else 
			this.displayView(null);
  }
}
