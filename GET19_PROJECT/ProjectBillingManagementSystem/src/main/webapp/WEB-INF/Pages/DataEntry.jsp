<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Entry page</title>
</head>
<body>

<div align="center">
	<c:if test="${msg ne null}">
		<h4>${msg}</h4>
	
	</c:if>
<fieldset>
	<legend>Welcome Data Entry Operator</legend>
	
	<a href="fillattendance">Click to add attendance</a>
	</br>
	
	
	
	</fieldset>>
</div>
</body>
</html>