<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Entry page</title>
<style>
.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}
body{
 background-image: url(images/backgroundimage1.jpg);
  margin-top: 50px;
  
}
#topleft {
  position: absolute;
  top: 8px;
  left: 16px;
}
</style>

<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()",0);
  window.onunload=function(){null};
  
  </script>


<body>
</head>
<jsp:include page="Header.jsp"/>


<div align="center" >

	
	<a href="fillattendance" style="color:white" id="click"><h2>Click to add attendance</h2></a>

</div>
<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>