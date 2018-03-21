<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<jsp:include page="head.jsp"></jsp:include>

<body>
	<div class="container">
		<form method="post" action="/admin">
			<div class="row">
				<div class="form-group">
					<div class="col-md">
						<label for="admin">Enter ID</label>
						<input type="text" class="form-control" id="admin" name="admin" placeholder="Enter ID" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="form-group">
					<div class="col-md">
						<label for="password">Enter Password</label>
						<input type="password" class="form-control" id="password" name="password" placeholder="Password" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md">
					<input type="hidden" name="action" id="action"/>
					<button type="submit" onclick="document.getElementById('action').value='adminLogin';" class="btn btn-primary">Submit</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>