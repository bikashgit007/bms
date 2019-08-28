<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
   <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Project Billing</title>
</head>
<jsp:include page="AdminHtml.jsp"/>
<style><%@include file="/WEB-INF/Pages/cssref/submit.css"%></style>

<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()",0);
  window.onunload=function(){null};
  </script>

<body>

<c:if test="${msg ne null}">${msg}</c:if>

<div align ="center" class="dataentrydiv1">
<table>
	<f:form action="${pageContext.request.contextPath}/seeProjectBilling" method="Post" modelAttribute="projectConfig">
	
			<tr>
			<td>
						<label style="font-size:20px;color:black">Project</label>
	</td>	
	<td>
						<f:select path="configid" style="font-size:15px;color:black">
							<f:option value="${0 }" >---Select Project---</f:option>
							<c:forEach items="${pList}" var="pObj">
								<f:option value="${pObj.projectid}">${pObj.projectname}</f:option>
								
								
							</c:forEach>
							
							
							</f:select>
							</td>
			</tr>
	
	
	
	
	
		
		<tr>
			<td>
				<label style="font-size:20px;color:black">Month</label>
			</td>
			
			
			<td>
			
		
					
					
			<select name="month" style="font-size:15px;color:black">
							<option value="${month}">${month}</option>
							
								
								<option value="jan">January</option>
								<option value="feb">February</option>
								<option value="mar">March</option>
								<option value="apr">April</option>
								<option value="may">May</option>
								<option value="jun">June</option>
								<option value="jul">July</option>
								<option value="aug">August</option>
								<option value="sep">September</option>
								<option value="oct">October</option>
								<option value="nov">November</option>
								<option value="dec">December</option>
							
							</select>
					
			
			
			
			
					
					
					
			</td>
		</tr>
		
		<tr>
				
				<td>
				<label style="font-size:20px;color:black">Year</label>
				</td>
				<td>
				
					<select name="year" style="font-size:15px;color:black"  required="true">
							<option value="${year}">${year}</option>
							
								
								<option value="2019">2019</option>
								<option value="2018">2018</option>
								<option value="2017">2017</option>
								<option value="2016">2016</option>
								<option value="2015">2015</option>
								<option value="2014">2014</option>
								<option value="2013">2013</option>
								
							
							</select>
					
					
					
		
					
				</td>
				
				
				</tr>
				<tr>
		<td>
			<c:if test="${proejctBilling ne null}">
							<tr>
							<td>
								<label  style="font-size:20px ;color:black">Total Billing Report</label>
								</td>
								<td>
								<input type="text" value="${proejctBilling}"  style="font-size:15px;color:black;" readonly>
								</td>
							</tr>
							</c:if>
		
		
		
		
		</td>
		
		
		
		
		</tr>
				
		
	
		<tr>
			<td><input type="submit" ><td>
		
		</tr>
	
	
		
	</f:form>
</table>
</div>
<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>