<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>

<div class="container">
	<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4">
			<h2 align="center">LOGIN </h2>
			<h3 align="center">[MINGLE OCEAN]</h3>
			<font color="red">${errorMessage}</font>
			<form method="POST">
				<div class="form-group">
					<label for="name">User name : </label>
					<input type="text" name="name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="name">Password : </label>
					<input type="password" name="password" class="form-control"/>
				</div>
				
				<input type="submit" class="btn btn-success" value="Login" />
			</form>	
		</div>
		<div class="col-sm-4"></div>
	</div>
</div>

<%@ include file="common/footer.jspf" %>
	