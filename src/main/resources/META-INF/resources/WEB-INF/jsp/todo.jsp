<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h2>Add a new to do</h2>
	<form:form method="post" modelAttribute="todo">
		<fieldset class="mb-3">
			<form:label path="description" class="form-label">Description</form:label>
			<form:input path="description" type="text" required="required" class="form-control" />
			<form:errors path="description" cssClass="text-danger" />
		</fieldset>
		<fieldset class="mb-3">
			<form:label path="targetDate" class="form-label">Deadline</form:label>
			<form:input path="targetDate" type="text" required="required" class="form-control" />
			<form:errors path="targetDate" cssClass="text-danger" />
		</fieldset>
		<form:input path="id" type="hidden" />
		<form:input path="done" type="hidden" />
		<button type="submit" class="btn btn-success">SUBMIT</button>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>
<script>
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>