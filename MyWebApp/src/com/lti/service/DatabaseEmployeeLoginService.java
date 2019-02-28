package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseEmployeeLoginService {
	

	public EmployeeDetails getEmployeeDetails(int empid) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			String sql = "select first_name, last_name, email, phone_number, hire_date, salary from employees where employee_id=? ";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, empid);
			rs = stmt.executeQuery();
			if(rs.next()) {
				EmployeeDetails emp = new EmployeeDetails();
				emp.setEmployeeId(empid);
				emp.setFirstname(rs.getString(1));
				emp.setLastName(rs.getString(2));
				emp.setEmail(rs.getString(3));
				emp.setPhonenumber(rs.getString(4));
				emp.setHireDate(rs.getString(5));
				emp.setSalary(rs.getDouble(6));
				
				return emp;
			}
			else
					return null; //should throw exception
		}
		catch(Exception e) {
			e.printStackTrace();		 //bad, should catch individual exception(s)
			return null;					//very bad, should throw user defined exception instead
		}
		finally {
			try {rs.close();} catch(Exception e){ }
			try {stmt.close();} catch(Exception e){ }
			try {conn.close();} catch(Exception e){ }
		}
	}
}

	