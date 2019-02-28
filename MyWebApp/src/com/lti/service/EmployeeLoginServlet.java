package com.lti.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/employeelogin.jpg")
public class EmployeeLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		DatabaseEmployeeLoginService employeeloginService = new DatabaseEmployeeLoginService();
		EmployeeDetails emp =  employeeloginService.getEmployeeDetails(empid);
		
		HttpSession session =  request.getSession();
		
			
			session.setAttribute("employeeData", emp);
			response.sendRedirect("welcome_employee.jsp");												

	}

}
