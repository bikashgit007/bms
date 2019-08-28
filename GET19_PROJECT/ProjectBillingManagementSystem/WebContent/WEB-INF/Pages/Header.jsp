<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="f"  uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <style><%@include file="/WEB-INF/Pages/cssref/submit.css"%></style>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  
  <link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.css" />
	<link type="text/css" rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid-theme.min.css" /> 
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jsgrid/1.5.3/jsgrid.min.js"></script>
	
</head>
<style>
.topright {
  position: absolute;
  top: 8px;
  right: 16px;
}
#topleft {
  position: absolute;
  top: 8px;
  left: 16px;
}
</style>
<body>
	<div align="right" style=color:white;padding-top:7px;width:1270px;font-size:20px;font-family:verdana; id="div1" >
	
					<c:if test="${sessionScope.userObj ne null}">
					Welcome ${sessionScope.userObj.name}
					
					
					<div class="topright">
	<div class="container-fluid" style="height:20px">
 	 <a id="logout" href="logOut" class="btn btn-info btn-lg">
          <span class="glyphicon glyphicon-log-out" ></span> Log out
        </a>
     </div>
	</div>
	
	</c:if>
	</div>
	
	
	
<div class="navbar-header" >
      <a class="navbar-brand" href="AdminPage">
      	
      	</a>
    </div>
    <div id="topleft">
 <a href="HomePage" ><img src="images/logo.gif" href="HomePage" style="width:400px;height:70px;opacity:0.8" alt="AdminPage"/></a>
  </div>
<script>
		
		var locations = [
			{ Name: "Onsite"},
			{ Name: "Offset"},
			
		];
	
		var projects;
			  $.ajax({url: "fetchProjects", success: function(result){
				projects=result;
			  }});
	
		$("a#getProjectConfiguration").click(function(){
			
		    	
		    //func starts
		    $(function() {			
				var filter=$("#jsgrid").jsGrid({
		  			 width: "100%",
		   			height: "400px",
					inserting: true,
		   			editing: true,
		   			sorting: true,
		   		 	autoload: true,
		   			paging: true,
		   			
		   			controller : {
			   			 loadData: function(filter) {
			   				 
			   	          return $.ajax({
			   	              type: "GET",
			   	              url: "fetchProjectConfigConfiguration",
			   	              data: filter
			   	            });
			   	        },
		   				insertItem:function(filter){
		   					return $.ajax({
		   		              type: "GET",
		   		              url: "addProjectConfigThroughAjax",
		   		              data: filter
		   		            });
		   					}
		   			},
		   			fields: [
							{ name: "project.projectname",type: "text",width: 200 , title:"Project"},
							{ name: "role.roleName",title:"Role", type: "text", width: 200 }, 
							{ name: "location", type: "select", items: locations, valueField: "Name", textField: "Name" },
		       				{ name: "perHourBilling", type: "number", width: 200 },
		       				{ type: "control" }
		       				
		   			]
				});
				 
				});//func ends;
		  
			 $("#div1").hide();
			 
		});
	
 
		
</script>