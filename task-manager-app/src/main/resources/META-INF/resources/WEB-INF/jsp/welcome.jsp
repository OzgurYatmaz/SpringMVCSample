
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<h1>Es selamu aleykum ${name}, welcome!</h1>

 	<a href="${pageContext.request.contextPath}/tasks" class="btn btn-success"> Manage your tasks</a>  
 	
  	<a href="${pageContext.request.contextPath}/showAllUsers" class="btn btn-warning"> Manage Users (for Admins)</a> 


</div>
<%@ include file="common/footer.jspf"%>