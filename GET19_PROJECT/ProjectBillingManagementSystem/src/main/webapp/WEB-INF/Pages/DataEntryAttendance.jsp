<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance</title>
</head>
<body>

<div align="center">
<table>
	<f:form Action="addAttendance" method="Post" modelAttribute="dataEntry">
	<tr>
	
		<td>
							<h5>Select Developer</h5>
							<f:select path="developer.id">
							<f:option value="none">---Select Developer----</f:option>
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
						
							
								<h5>Select Month And Year</h5>
								<f:input path="month" type="month" />
								
						
							
							
							
			
		</td>
		</tr>
		
		<tr>
		<td>
							
								<h5>Enter No. Half Days</h5>
								<input type="number" name="halfday" id="half">
								<br/>
								<h5>Enter No. Full Days</h5>
								<input type="number" name="fullday" id="full">
								<br/>
								
								
								<br/>
								<h5>Total No Of Hours Present in a month</h5>
								<f:input path="totalNoOfHoursPresent" id="hour" onfocus="cal()" readonly="true"/>
								
							
							
							
							
							
			
		</td>
		</tr>
		
		
		
				
		<tr>
			<td>
				<input type="submit">
		
			</td>
		</tr>
			
			</f:form>
		</table>
	</div>
		
<script type="text/javascript">
	function cal(){
		
		var h=document.getElementById('half').value;
		var f=document.getElementById('full').value;
		
		document.getElementById('hour').value=((h*4.5)+(f*9));
	}


</script>		
</body>


</html>