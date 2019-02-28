package com.lti.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseLoginService {
	
	public boolean isValidUser(String username, String password) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			String sql = "select count(1) from TBL_USER where username = ? and password = ? and active = 'Y' ";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				int count = rs.getInt(1);
				if(count==1)
					return true;
				return false;
			}
			else 
				return false;
		}
		catch(Exception e) {
			e.printStackTrace();		 //bad, should catch individual exception(s)
			return false;					//very bad, should throw user defined exception instead
		}
		finally {
			try {rs.close();} catch(Exception e){ }
			try {stmt.close();} catch(Exception e){ }
			try {conn.close();} catch(Exception e){ }
		}
	}
	public String getFullname(String username, String password) {
		String fullname = "Test";
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs= null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "Newuser123");
			String sql = "select fullname from TBL_USER where username = ? and password = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			if(rs.next()) {
				 fullname = rs.getString("fullname");
				return fullname;
			}
		}
		catch(Exception e) {
			e.printStackTrace();		 //bad, should catch individual exception(s)
			return fullname;					//very bad, should throw user defined exception instead
		}
		finally {
			try {rs.close();} catch(Exception e){ }
			try {stmt.close();} catch(Exception e){ }
			try {conn.close();} catch(Exception e){ }
		}
		return fullname;
	}
}

