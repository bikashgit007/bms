<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	
<jsp:include page="Header.jsp"/>

<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
</style>
<title>Login Page</title>
</head>
<body bgcolor="cyan">


<h3 align="center">Login</h3>
<div align="center">

<div class="container"  style="padding-top:70px">
  <h2 style="color:blue">Login Form</h2>
  <f:form action="validate" modelAttribute="dObj" method="post">
  <div class="form-group">
<table>
<tr>
<td>
Enter Id:
</td>
<td>
<f:input path="id" />
</td>
</tr>
<tr>
<td>
Enter Password:
</td>
<td>
<f:input path="password" type="password"/>
</td>
</tr>
<tr>
<td>
<input type="submit" value="Login" />
</td>
</tr>

</table>
</f:form>
</div>
</body>
</html>