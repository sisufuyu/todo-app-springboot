<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h2>Login</h2>
	<form method="post">
		<div  class="mb-3">
			<label for="name" class="form-label">Name</label>
			<input id="name" type="text" name="name" class="form-control" />
		</div>
		<div  class="mb-3">
			<label for="password" class="form-label">Password</label>
			<input id="password" type="password" name="password" class="form-control" />
		</div>
		<button type="submit" class="btn btn-primary">Login</button>
		<p class="text-danger" >${error}</p>
	</form>
</div>
<%@ include file="common/footer.jspf" %>