<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h2>Your To Do List</h2>
	<table class="table">
		<thead>
			<tr>
				<th>Description</th>
				<th>Deadline</th>
				<th>Is Done?</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-warning">UPDATE</a></td>
					<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-todo" class="btn btn-success">ADD A NEW TODO</a>
</div>
<%@ include file="common/footer.jspf" %>