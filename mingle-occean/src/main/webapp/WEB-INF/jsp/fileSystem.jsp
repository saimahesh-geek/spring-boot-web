<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>

<div class="container">	
	<h1>Hi ${name} !!</h1>	
	<div class="row">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<a class="btn btn-success" href="/add-file" type="button">Add (+)</a>
			<table class="table table-striped">
				<thead>
					<th>File Name</th>
					<th>Created By</th>
					<th>Creation Date</th>
					<th>File Type</th>
					<th>Operations</th>
				</thead>
				<tbody>
					<c:forEach items="${files}" var="file">
						<tr>
							<td>${file.name}</td>
							<td>${file.createdBy}</td>
							<td><fmt:formatDate pattern="dd/MM/yyyy" value="${file.creationDate}"/></td>
							<td>${file.type}</td>
							<td>
								<a type="button" class="btn btn-success" href="/update-file?id=${file.id}">Update</a>
								<a type="button" class="btn btn-warning" href="/delete-file?id=${file.id}">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="col-sm-2"></div>
	</div>		
</div>	

<%@ include file="common/footer.jspf" %>