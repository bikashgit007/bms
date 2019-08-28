<%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Projects</title>
</head>
<style><%@include file="/WEB-INF/Pages/cssref/submit.css"%></style>
<body>

<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()",0);
  window.onunload=function(){null};
  </script>

<jsp:include page="AdminHtml.jsp"/>

<c:if test="${msg}">${msg}</c:if>

<div align ="center" class="dataentrydiv1">
	<table>
	<f:form action="developerAllocated" method="get" modelAttribute="devConfigObj">
	<tr>
	
	
	
		<td>
						<label style="font-size:20px;color:black" required="true">Developer</label>
	</td>	
	
		<td>
							<f:select path="developer.id" style="font-size:15px; color:black" required="true">
							<f:option value="${0}">---Select Developer----</f:option>
							<c:forEach items="${dList}" var="dObj">
								<c:if test="${dObj.applicationRole=='Developer'}">
								<f:option value="${dObj.id}">${dObj.name}</f:option>
								</c:if>
							</c:forEach>
							</f:select>
							
							
							
							
			
		</td>
		</tr>
		<tr>	
		
		
		
		<td>
						<label style="font-size:20px; color:black" required="true">Project Config</label>
	</td>	
	
			<td>
			
							
							
							<f:select path="projectConfig.configid" style="font-size:15px;color:black" >
							<f:option value="${0}">---Select Project configuration----</f:option>
							<c:forEach items="${configList}" var="configObj">
								<f:option value="${configObj.configid}">${configObj.project.projectname},${configObj.role.roleName},${configObj.location}</f:option>
							</c:forEach>
							</f:select>
							
							
							
			
			</td>
			</tr>
			
				
		<tr>
			<td>
				<input type="submit" class="submitButton" >
				 
		
			</td>
		</tr>
			
			</f:form>
		</table>
		</div>
		<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>