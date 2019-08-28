<%@taglib prefix = "c" uri ="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Header.jsp"/>

<table id="jsGrid">
</table>

<style>
body{
 background-image: url(images/backgroundimage1.jpg);
  margin-top: 50px;
  
}
#topleft {
  position: absolute;
  top: 8px;
  left: 16px;
}
</style>

<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()",0);
  window.onunload=function(){null};
  
  </script>
<%-- <div class="container">--%>
<nav class="navbar navbar-default">
<div id="jsgrid">
    <c:if test="${userObj ne null && userObj.applicationRole eq 'Admin'}">
    <ul class="nav navbar-nav">
      <li ><a href="ProjectConfigTable" >Project Configuration</a></li>
      <li><a href="addDeveloperAllocation">Developer Allocation</a></li>
     <li  class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Billing
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="DeveloperBilling">Developer Billing</a></li>
          <li><a href="ProjectBilling">Project Billing</a></li>
          
        </ul>
      </li>
      
    </ul>
    </c:if>
</div>
  
  
  
</nav>




<jsp:include page="Footer.jsp"/>
	
	
</body>