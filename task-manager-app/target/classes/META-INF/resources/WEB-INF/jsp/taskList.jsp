    <%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<div>Welcome Mr ${name}</div>
		<hr>
		<h1>Here are your Tasks:</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Given Date</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.givenDate}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.done}</td>
						<td><a type="button" class="btn btn-warning"
							href="/deleteTask?id=${todo.id}"> Delete</a></td>
						<td><a type="button" class="btn btn-success"
							href="/updateTask?id=${todo.id}"> Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-task" class="btn btn-success">Add Task</a>
	</div>
	<%@ include file="common/footer.jspf" %>

 	
