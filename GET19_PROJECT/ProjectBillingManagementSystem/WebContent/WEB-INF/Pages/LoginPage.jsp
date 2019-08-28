<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()",0);
  window.onunload=function(){null};
  
  </script>
 


<jsp:include page="Header.jsp"/>

<style>

.msg
{

color: #ffffff;
	font-style: italic;
	font-weight: bold;
	font-size:30px;
}
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





<div align="center">
<div class="msg">
<c:if  test="${msg ne null}">${msg}</c:if>
</div>

<div class="container"  style="padding-top:70px">
  <h2 style="color:white">Login Page</h2>
  
  <c:if test="${param.msg ne null}">
  	<div class="alert alert-info">
  		${param.msg}
  	</div>
  </c:if>
  <f:form action="validate" modelAttribute="dObj" method="post">
    <div class="form-group">
      <label for="userId" style="color:white">User Id:</label>
      <i class="icon-user icon-large"></i>
      <f:input type="number" class="form-control" id="userId" placeholder="Enter Id"  path="id" style="width:300px" required="true"/>
    </div>
    <div class="form-group">
      <label for="pwd" style="color:white">Password:</label>
      <f:input type="password" class="form-control" id="pwd" placeholder="Enter password" path="password" style="width:300px" required="true"/>
    </div>
    
    
    <button type="submit"  class="btn btn-primary" >Login</button>
  </f:form>
</div>

</div>

<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>