package com.blissWebApp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ajaxRequest/*")
public class ServletAjaxRequest extends UtilHttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void monitoringmachine(){
		System.out.println("Monitoring machine");
		this.displayView(null);
	}
}
