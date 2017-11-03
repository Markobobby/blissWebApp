package com.blissWebApp.controller;

import javax.servlet.annotation.WebServlet;

@WebServlet("/auth/*")
public class ServletAuthentication extends UtilHttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletAuthentication() {
        // TODO Auto-generated constructor stub
    }
    
    public void managementmachine(){
    	this.displayView(null);
    }
    
    public void managementroom(){
    	this.displayView(null);
    }
}
