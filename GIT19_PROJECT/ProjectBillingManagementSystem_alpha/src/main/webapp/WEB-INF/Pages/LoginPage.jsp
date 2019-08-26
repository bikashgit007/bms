<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body bgcolor="cyan">


<h3 align="center">Login</h3>
<div align="center">


<f:form action="validate" modelAttribute="dObj" method="post">
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
<f:input path="password" type="password" />
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