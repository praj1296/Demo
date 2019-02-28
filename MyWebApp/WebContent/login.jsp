<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<%--<b><%= session.getAttribute("message")%></b>--%>						<!--  getting message for invalid username and password -->
<% 
	String message = (String) session.getAttribute("message");
	if(message!=null)
		out.println("<b>" + message + "</b>");
	session.removeAttribute("message");
 %>
<form method= "post" action="login.form.jpg">				<!--Kindly check for proper servlet url-->
<table>
<tr>
<td>Username</td>
<td> <input type="text" name="username">
</tr>
<tr>
<td>Password</td>
<td> <input type="password" name="password">
</tr>
</table>
<button type="submit">Login</button>
</form>
</body>
</html>