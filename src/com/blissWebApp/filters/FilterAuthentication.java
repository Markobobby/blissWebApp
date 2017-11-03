package com.blissWebApp.filters;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blissWebApp.dao.SalleDAO;
import com.blissWebApp.metier.Salle;


@WebFilter("/home/*")
public class FilterAuthentication implements Filter {

    public FilterAuthentication() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String url = req.getRequestURI().toString();
		System.out.println(url);
		System.out.println(req.getSession().getAttribute("USER")) ;
		if( url.contains("/home/index")){
			String dir = "/WEB-INF/views/home/index.jsp";
			List<Salle> salle= SalleDAO.getSalleList();
			req.setAttribute("model", salle);
			req.getRequestDispatcher(dir).forward(req, resp);
			return;
		} else if (url.contains("/home/connexion")){
			String dir = "/WEB-INF/views/home/connexion.jsp";
			req.getRequestDispatcher(dir);
		}else{
			if(req.getSession().getAttribute("USER") == null){
				url = req.getContextPath() + "/home/connexion";
				try {
					String redirect = req.getRequestURI();
					req.getSession().setAttribute("redirect", redirect);
					resp.sendRedirect(url);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return;
			}
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
