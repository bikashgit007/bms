<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
 
    
<%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Projects</title>
</head>
<style><%@include file="/WEB-INF/Pages/cssref/submit.css"%></style>
<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()",0);
  window.onunload=function(){null};
  </script>

<jsp:include page="AdminHtml.jsp"/>
<jsp:include page="Insert.jsp"/>

	
	<c:if test="${param.msg ne null}">
		<div class="container alert alert-info">
		${param.msg}
		</div>
	</c:if>
	
	
	
	
	<div align="center" style="margin-bottom:150px; background-color:white">
	
	
	<c:if test="${msg ne null}">${msg}</c:if>
	
	
	<table border=3 class="table table-borderless">
	<thead align="center" style="font-size:20px">
	
	<tr>
			
			<th style="color:black">Config Id</th>
			<th style="color:black">Project Name</th>
			<th style="color:black">Role</th>
			<th style="color:black">Location</th>
			<th style="color:black">Per Hour Billing</th>
			<th style="color:blue">Update</th>
			<th style="color:blue">Delete</th>
			
	</tr>
	</thead>
	<tbody>
			<c:forEach items="${ProjectConfigList}" var="pObj">
			
				
			
				<tr>
				<td>
						<h4 style="color:black">${pObj.configid}</h4>
						
				</td>
				
			
			
			
				
				<td>
						<h4 style="color:black">${pObj.project.projectname}</h4>
					
			
			
				
				</td>
		
			
			
			
				<td>
						<h4 style="color:black">${pObj.role.roleName}</h4>
						
						
				</td>
			
			
			
			
			
			
			
			
				<td>
						<h4 style="color:black">${pObj.location}</h4>
				
				</td>
			
			
			
			
			
			
			
			
				<td>
						<h4 style="color:black">${pObj.perHourBilling}</h4>
				
				</td>
			
			
			
			
			
			
			
			
				<td>
						<a href="${pageContext.request.contextPath}/updateProjectConfig/${pObj.configid}" style="color:blue">Update</a>
				
				</td>
			
			
			
			
			
			
				<td>
						
						
						<a href="${pageContext.request.contextPath}/deleteProjectConfig/${pObj.configid}" style="color:blue" >Delete</a>
						
						
						
				
				</td>
			
			
			
			
			
			</tr>
			
			
			</c:forEach>
			
			
	
	
	
	</tbody>
	</table>
	</div>
	
	
		<jsp:include page="Footer.jsp"/>
</body>
</html>