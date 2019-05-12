<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
		<h2>Person Data</h2>
		<form action="./addUser" method="post">
			<div class="form-group">
				<label for="UserName">User Name:</label> <input type="text"
					class="form-control" id="UserName" placeholder="Enter UserName"
					name="username">
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" id="password" placeholder="Enter Password"
					name="password">
			</div>
			<div class="form-group">
				<label for="mobileNo">Mobile Number:</label> <input type="number"
					class="form-control" id="mobileNo" placeholder="Enter MobileNumber"
					name="mobileNo">
			</div>
			<div class="form-group">
				<label for="role">Role:</label> 
				<input type="radio"class="form-group" id="role" name="role" value="User">User
				<input type="radio" class="form-group" id="role" name="role" value="Admin">Admin
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
	</div>
</body>
</html>