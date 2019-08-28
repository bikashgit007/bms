<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
  <title>Bootstrap Example</title>
  <style><%@include file="/WEB-INF/Pages/cssref/submit.css"%></style>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
  <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" /> 
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>
	
</head>

<style>
body{

background-color:black;

}

</style>


<body >

<div align="center" class="dataentrydiv1">
	<table>
	<f:form Action="${pageContext.request.contextPath}/addProjectConfig" method="get" modelAttribute="configObj">
	<tr>
	
	<td style="font-size:20px;color:black">
	Project Name:
	</td>
		<td>
		
			
							<c:if test="${configid ne null}">
								<f:hidden path="configid" value="${configid}"/>
							</c:if>
							
							<f:select path="project.projectid" style="font-size:15px;color:black">
							<f:option value="${pObj.project.projectid}">${pObj.project.projectname}</f:option>
							<c:forEach items="${pList}" var="pObjList">
								<f:option value="${pObjList.projectid}">${pObjList.projectname}</f:option>
							</c:forEach>
							</f:select>
							
							
							
							
			
		</td>
		</tr>
		<tr>	
		
		<td style="font-size:20px;color:black">
	Role Name:
	</td>
			<td>
			
							
							
							<f:select path="role.roleId" style="font-size:15px;color:black">
							<f:option value="${0}">---Select Role----</f:option>
							<c:forEach items="${rList}" var="rObj">
								<f:option value="${rObj.roleId}">${rObj.roleName}</f:option>
							</c:forEach>
							</f:select>
							
							
							
			
			</td>
			</tr>
			
				<tr>
				
				<td style="font-size:20px;color:black">
	Location
	</td>
		<td>
							<div class="radio-toolbarlabel">
							<f:radiobutton path="location" value="Onsite" name="o" style="font-size:15px;color:black"/>Onsite
							<br/>
							<f:radiobutton path="location" value="Offsite" name="o" style="font-size:15px;color:black"/>Offshore
							</div>
							
							
							
							
							
							
			
		</td>
		</tr>
		
			<tr>
			<td style="font-size:20px;color:black">
	Per Hour Billing:
	</td>
		<td>
							<f:input type="text" path="perHourBilling" style="font-size:15px;color:black"/>
							
							
							
							
							
							
			
		</td>
		</tr>
		<tr>
			<td>
				<div align="center" class="submitButton">
				<input type="submit">
				</div>
			</td>
		</tr>
			
			</f:form>
		</table> 
		</div>
			<div align="center">
		<jsp:include page="Footer.jsp"/>
		</div>


</body>
</html>