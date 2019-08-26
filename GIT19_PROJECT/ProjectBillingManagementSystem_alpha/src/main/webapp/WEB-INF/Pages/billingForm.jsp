<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<c:if test="${msg ne null}">${msg}</c:if>
	<table>
	<f:form Action="${pageContext.request.contextPath}/reportDeveloperBilling" method="Post" modelAttribute="devAlloc">
	<tr>
		<td>
							<f:select path="allocationId">
							<f:option value="none">---Select Developer----</f:option>
							<c:forEach items="${devAllocList}" var="dObj">
								<f:option value="${dObj.projectConfig.configid}">${dObj.developer.id},${dObj.projectConfig.configid},${dObj.projectConfig.project.projectname}</f:option>
								
								
							</c:forEach>
							
							
							</f:select>
							
							
							
							
							
							
							
			
						
			
							
							<c:if test="${totalBill ne null}">
								<h4>Total Billing Report</h4>
								<input type="text" value="${totalBill}" readonly>
							
							</c:if>
							
							
							
			
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
</body>
</html>