<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Attendance</title>

<style><%@include file="/WEB-INF/Pages/cssref/submit.css"%>
.button {
  background-color: #4CAF50; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  box-color: grey;
  margin:right;
}

</style>
<jsp:include page="DataEntry.jsp"/>

<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()",0);
  window.onunload=function(){null};
  </script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

$(document).ready(function(){
	{
	  $("a").hide();
	});

	});
</script>
</head>
<body>

	<div align ="center" class="dataentrydiv1">
	
<table>
	<f:form Action="addAttendance" method="post" modelAttribute="dataEntry">
				
							
	<tr>
	
	
	<td>
						<label style="font-size:20px;color:black">Developer</label>
	</td>	

							
		<td>
							
							<f:select path="developer.id" style="font-size:15px;color:black"  required="true">
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
						<label style="font-size:20px;color:black ">Months</label>
	</td>		
		
		<td>
					
					
					
					<f:select path="month" style="font-size:15px;color:black"  required="true">>
							<f:option value="${none}">---Select Month----</f:option>
							
								
								<f:option value="jan">january</f:option>
								<f:option value="feb">february</f:option>
								<f:option value="mar">march</f:option>
								<f:option value="apr">april</f:option>
								<f:option value="may">may</f:option>
								<f:option value="jun">june</f:option>
								<f:option value="jul">july</f:option>
								<f:option value="aug">august</f:option>
								<f:option value="sep">september</f:option>
								<f:option value="oct">october</f:option>
								<f:option value="nov">november</f:option>
								<f:option value="dec">december</f:option>
							
							</f:select>
					
					
					
					
							
						
		</td>
		</tr>
		
		<tr>
		<td>
		<label style="font-size:20px;color:black" required>Year</label>
		
		</td>
		
			<td>
					
								
							<f:select path="year" style="font-size:15px;color:black"  required="true">>
							<f:option value="${none}">---Select Year----</f:option>
							
								
								<f:option value="2019">2019</f:option>
								<f:option value="2018">2018</f:option>
								<f:option value="2017">2017</f:option>
								<f:option value="2016">2016</f:option>
								<f:option value="2015">2015</f:option>
								<f:option value="2014">2014</f:option>
								
							
							</f:select>
		</td>
		
		
		
		</tr>
		<tr>
		<td>
		
						<label style="font-size:20px;color:black" >Full Day</label>
	
		
		</td>
		<td>
		
						<input type="number" style="font-size:15px" id="full" required/>
						</td>
		</tr>
		
		<tr>
		<td>
		
						<label style="font-size:20px;color:black" >Half Day</label>
	
		
		</td>
		<td>
		
						<input type="number" style="font-size:15px" id="half" required/></td>
		</tr>
		
		
		<tr>
		
		<td>
		  <label style="font-size:20px;color:black">Total Hours </label>
		
	</td>
		<td>
		
		
		
					
								<f:input path="totalNoOfHoursPresent" style="font-size:15px;color:black" id="hour" onfocus="cal()" readonly="true" required="true"/>
						
		</td>
		</tr>
	
		<tr>
			<td>
				<div align="center">
				<input type="submit" value="SUBMIT" class="submitButton">
				</div>
			</td>
		</tr>
			
			</f:form>
		</table>
		</div>		
		
		<jsp:include page="Footer.jsp"/>
		
		
		<script type="text/javascript">
	function cal(){
		
		var h=document.getElementById('half').value;
		var f=document.getElementById('full').value;
		
		document.getElementById('hour').value=((h*4.5)+(f*9));
	}


</script>		
</body>
</html>