package com.CourseScheduler.ui;

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
import javax.servlet.http.HttpSession;

/**
 * Filter requests if authenticated or not
 * This can probably be improved...
 * @author Connor
 *
 */
@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//FacesContext currentInstance = FacesContext.getCurrentInstance();
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		HttpSession session = request.getSession(false);
		String requestURI = request.getRequestURI();
			
		boolean loggedIn = (session != null && session.getAttribute("auth") != null);
		boolean isLoggedOutPage = requestURI.equals(request.getContextPath() + "/")
				|| requestURI.indexOf("/index.xhtml") >= 0
				|| requestURI.indexOf("/signup.xhtml") >= 0;
		boolean isResource = (request.getRequestURI().indexOf("/assets/") >= 0
			|| requestURI.contains("javax.faces.resource"));
			
		// Check if logged in, accessing logged in/out-only urls, or is resource
		if (((loggedIn && !isLoggedOutPage) || (!loggedIn && isLoggedOutPage)) || isResource) {
			chain.doFilter(request, response);
		} else if (loggedIn) {
			response.sendRedirect(request.getContextPath() + "/searchcourses.xhtml");
		} else {
			response.sendRedirect(request.getContextPath() + "/index.xhtml");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
