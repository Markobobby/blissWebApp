package com.blissWebApp.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.blissWebApp.dao.SalleDAO;
import com.blissWebApp.dao.UserDAO;
import com.blissWebApp.metier.Salle;
import com.blissWebApp.metier.User;

@WebServlet("/home/*")
public class ServletHome extends UtilHttpServlet {
	UserDAO userDao;
	SalleDAO salleDao;
	
	private static final long serialVersionUID = 1L;
	
	public void index(){
		List<Salle> salle= SalleDAO.getSalleList();
		this.displayView(salle);
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
  	this.displayView(null);
  }
  
  public void managementroom(){
  	
  }
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
