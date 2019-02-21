<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>

<div class="container">
	<h1>Add File</h1>
	<form:form method="POST" modelAttribute="file">
		<div class="form-group">
			<form:label path="name">File Name : </form:label>
			<form:input path="name" type="text" class="form-control" name="name" required="required"/>
			<form:errors path="name" cssClass="text-warning"/>
		</div>
		<div class="form-group">
			<form:label path="creationDate">Creation Date : </form:label>
			<form:input path="creationDate" type="text" class="form-control" name="name" required="required"/>
			<form:errors path="creationDate" cssClass="text-warning"/>
		</div>
		<input type="submit" value="Save" class="btn btn-success"/>
	</form:form>
</div>	


<%@ include file="common/footer.jspf" %>