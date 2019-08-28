<style>

body{
 background-image: url(images/backgroundimage1.jpg);
  margin-top: 20px;
  opacity:0.8;
  
}

</style>
<script type="text/javascript">
  function preventBack(){window.history.forward();}
  setTimeout("preventBack()",0);
  window.onunload=function(){null};
  </script>


 <div class="topleft">
  <img src="images/logo.gif" style="width:300px;height:80px" alt="AdminPage"/>
  </div>

<div align="center">
<h2  align="center" style="color:#FFFFFF; padding-top:150px;font-size:60px;font-family: verdana">Project Billing Management System</h2>
</div>
<div align="center">
	<a style="color:white;" href="Login" ><h2>SignIn</h2></a>
	
</div>

  
  	<div align="center">
	<jsp:include page="Footer.jsp"/>
	</div>
</body>