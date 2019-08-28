<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Billing</title>
</head>
<style><%@include file="/WEB-INF/Pages/cssref/submit.css"%></style>
<body>
<jsp:include page="AdminHtml.jsp"/>
<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()",0);
  window.onunload=function(){null};
  
  </script>

<c:if test="${msg ne null}">${msg}</c:if>
<div align ="center" class="dataentrydiv1">
	<table>
	<f:form Action="${pageContext.request.contextPath}/reportDeveloperBilling" method="Post" modelAttribute="devAlloc">
	<tr>
	
	<td>
	<label style="font-size:20px;color:black">Developer Config</label>
	</td>
		<td>
							<f:select path="allocationId" style="font-size:15px;color:black;" required="true">
					
							<f:option value="${0}">---Select Developer----</f:option>
							<c:forEach items="${devAllocList}" var="dObj">
								<f:option value="${dObj.projectConfig.configid}">${dObj.developer.name},${dObj.projectConfig.configid},${dObj.projectConfig.project.projectname}</f:option>
								
								
							</c:forEach>
							
							
							</f:select>
						
				
				
				</td>
				
				</tr>
				
				<tr>
				<td>
				<label style="font-size:20px;color:black">Month</label>
				
				</td>
				
				<td>
				
					<select name="month" style="font-size:15px;color:black"  required="true">>
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
				
				
				
				
				<tr>
				
				<td>
				
				
				
							
							<c:if test="${totalBill ne null}">
							<tr>
							<td>
								<label  style="font-size:15px;color:black;">Total Billing Report</label>
								</td>
								<td>
								<input type="text" value="${totalBill}"  style="font-size:15px" readonly>
								</td>
							</tr>
							</c:if>
							
							
							
			
		</td>
		</tr>
		
			
				
		<tr>
			<td>
				<input type="submit"  class="class="submitButton">
		
			</td>
		</tr>
			
			</f:form>
		</table>
		</div>
		<jsp:include page="Footer.jsp"/>
</body>
</body>
</html>