package com.blissWebApp.controller;

import javax.servlet.annotation.WebServlet;

@WebServlet("/home/*")
public class ServletHome extends UtilHttpServlet {
	private static final long serialVersionUID = 1L;
	
    public void index(){
    	System.out.println("index");
    	this.displayView(null);
    }
}
