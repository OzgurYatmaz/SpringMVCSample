<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
	<div class="container">

		<h1>Enter User details:</h1>
		<form:form action="addUser" method="post" modelAttribute="user">
		
		<form:input type="hidden" path="id" />
		
			<fieldset class="mb-3">
				<form:label path="name">Name</form:label>
				<form:input type="text" path="name" required="required" />
				<form:errors path="name" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="password">password</form:label>
				<form:input type="text" path="password" required="required" />
				<form:errors path="password" cssClass="text-warning" />
			</fieldset>
			<fieldset class="mb-3">
				<form:label path="email">Email</form:label>
				<form:input type="text" path="email" required="required" />
				<form:errors path="email" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="mb-3">
				 Role:  
				 User<form:radiobutton path="role" value="USER" />  
       			 Admin<form:radiobutton path="role" value="ADMIN"/>  
       			 Owner<form:radiobutton path="role" value="OWNER" disabled="true"/>
        		  
			</fieldset>
			 
			<input type="submit" class="btn btn-success" />
		</form:form>
	</div>
<%@ include file="common/footer.jspf" %>

 

