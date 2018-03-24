<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head.jsp"></jsp:include>
<body>
    <jsp:include page="navbar-without-buttons.jsp"></jsp:include>
	<br>
	<c:choose>
		<c:when test="{message=='Error'}">
	    	<div class="alert alert-danger">
	    		Could not send the request!
	    	</div>
	    </c:when>

		<c:when test="${not empty message}">
			<div class="alert alert-success">
	    		Request sent sussecssfully! RequestId for reference is: ${message}
	    	</div>
	    </c:when> 
	    
	    <c:otherwise>
			<div class="container col-md-7">
				<div class="col-md-10">
					<div class="row">
						<form method="post" action="/dealer.do">
							<div class="col-sm-12">
								<div class="row">
									<div class="col-sm-6 form-group">
										<label>First Name</label>
										<input autofocus type="text" name="firstName" class="form-control" required>
									</div>
									<div class="col-sm-6 form-group">
										<label>Last Name</label>
										<input type="text" name="lastName" class="form-control" required>
									</div>
								</div>					
								<div class="form-group">
									<label>Address</label>
									<textarea rows="2" name="address" class="form-control" required></textarea>
								</div>
								<div class="form-group">
									<label>Company Name</label>
									<input type="text" name="company" class="form-control" required>
								</div>
								<div class="form-group">
									<label>Phone Number</label>
									<div class="input-group mb-3">
									  <div class="input-group-prepend">
									    <span class="input-group-text" id="basic-addon1">+91</span>
									  </div>
									  <input type="number" class="form-control" name="mobile" aria-label="phonenumber" aria-describedby="basic-addon1" required>
									</div>
								</div>		
								<div class="form-group">
									<label>Email Address</label>
									<input type="email" placeholder="sample@company.com" name="email" class="form-control" required>
								</div>
								<div class="form-group">
									<input type="checkbox" aria-label="Checkbox for following text input" required>
									<button type="button" class="btn btn-link" data-toggle="modal" data-target="#dealerPrivacyPolicyModal">
									I read privacy policies of this company.
									</button>
								</div>
								<button type="submit" name="registerDealer" class="btn btn-info">Submit</button>					
							</div>
						</form> 
					</div>
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	</body>
</html>