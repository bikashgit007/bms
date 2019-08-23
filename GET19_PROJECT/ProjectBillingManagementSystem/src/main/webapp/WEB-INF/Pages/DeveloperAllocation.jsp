<%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Projects</title>
</head>
<body>

<c:if test="${msg ne null}">${msg}</c:if>
	<table>
	<f:form Action="developerAllocated" method="get" modelAttribute="devConfigObj">
	<tr>
		<td>
							<f:select path="developer.id">
							<f:option value="none">---Select Developer----</f:option>
							<c:forEach items="${dList}" var="dObj">
								<c:if test="${dObj.applicationRole=='Developer'}">
								<f:option value="${dObj.id}">${dObj.id}</f:option>
								</c:if>
							</c:forEach>
							</f:select>
							
							
							
							
			
		</td>
		</tr>
		<tr>	
			<td>
			
							
							
							<f:select path="projectConfig.configid">
							<f:option value="none">---Select Project configuration----</f:option>
							<c:forEach items="${configList}" var="configObj">
								<f:option value="${configObj.configid}">${configObj.project.projectname},${configObj.role.roleName},${configObj.location}</f:option>
							</c:forEach>
							</f:select>
							
							
							
			
			</td>
			</tr>
			
				
		<tr>
			<td>
				<input type="submit">
		
			</td>
		</tr>
			
			</f:form>
		</table>
		
</body>
</html>