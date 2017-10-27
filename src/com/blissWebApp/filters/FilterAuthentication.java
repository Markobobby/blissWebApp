package com.blissWebApp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class FilterAuthentication implements Filter {
	
	
    public FilterAuthentication() {
    }
    
	public void destroy() {
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		if(req.getSession().getAttribute("USER") == null){
			HttpServletResponse resp = (HttpServletResponse)response;
			String url = req.getContextPath() + "/auth/login";
			try {
				req.getSession().setAttribute("REDIRECT", req.getRequestURI());
				resp.sendRedirect(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
