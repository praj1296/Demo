<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

<h1>Welcome back, <%= session.getAttribute("loggedInUser") %></h1>				<!-- here we have embeded the value of logged in user  -->
<br>
<h2>You have successfully Logged In</h2>
</body>
</html>