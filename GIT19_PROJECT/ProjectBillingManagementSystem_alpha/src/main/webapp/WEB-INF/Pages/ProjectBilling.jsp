<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
   <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:if test="${msg ne null}">${msg}</c:if>
<table>
	<f:form action="${pageContext.request.contextPath}/seeProjectBilling" method="Post" modelAttribute="projectConfig">
	
			<tr>
						<f:select path="configid">
							<f:option value="none" style="font-size:25px">---Select Developer----</f:option>
							<c:forEach items="${pConfigList}" var="pObj">
								<f:option value="${pObj.project.projectname}">${pObj.project.projectname}</f:option>
								
								
							</c:forEach>
							
							
							</f:select>
			</tr>
	
	
		
	</f:form>
</table>
</body>
</html>