
<%@page import="com.lti.service.EmployeeDetails"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Employee</title>
</head>
<body>
<h1>Welcome!</h1>				<!-- here we have embeded the value of logged in user  -->
<br>
<h2>Kindly find your Details</h2> 



<%
	EmployeeDetails emp= (EmployeeDetails) session.getAttribute("employeeData");
%>

Employee Id: <%= emp.getEmployeeId() %><br>
First Name: <%= emp.getFirstname() %><br>
Last Name: <%= emp.getLastName() %><br>
Email:  <%= emp.getEmail() %><br>
Phone Number:  <%= emp.getPhonenumber() %><br>
Hire date: <%= emp.getHireDate() %><br>
Salary: <%= emp.getSalary() %><br>

</body>
</html>