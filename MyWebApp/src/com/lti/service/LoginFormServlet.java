package com.lti.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.form.jpg")
public class LoginFormServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String username = request.getParameter("username");							//getting username and password 
		String password = request.getParameter("password");							//from user
		//InMemoryLoginService loginService = new InMemoryLoginService();									//new class created
		DatabaseLoginService loginService = new DatabaseLoginService();										//loginService is object of DatabaseLoginService
		boolean isValid = loginService.isValidUser(username,password);      										//validating the input
		
		HttpSession session =  request.getSession();		
		//session management
		if(isValid) {
			
		String fullname = loginService.getFullname( username, password);	//fullname is declared for function getFullname
			session.setAttribute("loggedInUser", fullname);							//key value pair
			response.sendRedirect("welcome.jsp");											//redirecting	
		}
			else
			session.setAttribute("message", "Invalid Username/Password");
			response.sendRedirect("login.jsp");
		
		
		/*if (username.equals("prajakta") && password.equals("1296"))
			response.sendRedirect("welcome.html");							//if login successful redirect=> welcome.html

		else
			response.sendRedirect("login.html");									//if login failed redirect => login.html
*/
	}

}
