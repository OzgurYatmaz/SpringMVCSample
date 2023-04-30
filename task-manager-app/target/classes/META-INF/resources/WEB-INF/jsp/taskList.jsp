    <%@ include file="common/header.jspf" %>
	<%@ include file="common/navigation.jspf" %>

	<div class="container">
		<div>Welcome Dear ${name}</div>
		<hr>
		<h1>Here are your tasks:</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Priority</th>
					<th>Description</th>
					<th>Given Date</th>
					<th>Target Date</th>
					<th>Is Done?</th>
					<th>Remaining Time</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${tasks}" var="task">
					<tr>
						<td>${task.priority}</td>
						<td>${task.description}</td>
						<td>${task.givenDate}</td>
						<td>${task.targetDate}</td>
						<td>${task.done}</td>
						<td>${task.remainingTime}</td>
						<td><a type="button" class="btn btn-warning"
							href="${pageContext.request.contextPath}/deleteTask?id=${task.id}"> Delete</a></td>
						<td><a type="button" class="btn btn-success"
							href="${pageContext.request.contextPath}/updateTask?id=${task.id}"> Update</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="${pageContext.request.contextPath}/add-task" class="btn btn-success">Add Task</a>
	</div>
	<%@ include file="common/footer.jspf" %>

 	
