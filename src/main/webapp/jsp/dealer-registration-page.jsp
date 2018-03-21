<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head.jsp"></jsp:include>
<body>

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
	    	<div class="container">
				<div class="col-lg-12 well">
					<div class="row">
						<form id="dealerForm" method="post" class="margin10" action="/dealer">
							<div class="col-sm-12">
								<div class="row">
									<div class="col-sm-6 form-group">
										<label>First Name</label>
										<input name="firstName" type="text" required placeholder="Enter First Name Here" class="form-control">
									</div>
									<div class="col-sm-6 form-group">
										<label>Last Name</label>
										<input name="lastName" type="text" required placeholder="Enter Last Name Here" class="form-control">
									</div>
								</div>					
								<div class="form-group">
									<label>Address</label>
									<textarea  name="address" required placeholder="Enter Address Here" rows="5" class="form-control"></textarea>
								</div>				
								<div class="form-group">
									<label>Phone Number</label>
									<input  name="mobile" pattern="[0-9]{10}" type="number" required placeholder="Enter Phone Number Here" class="form-control">
								</div>		
								<div class="form-group">
									<label>Email Address</label>
									<input name="email" type="email" required placeholder="Enter Email Address Here" class="form-control">
								</div>		
								<input type="hidden" name="action" id="action"/>
								<button type="submit" onclick="document.getElementById('action').value='registerDealer';document.getElementById('dealerForm').submit();" class="btn btn-lg btn-info">
									Submit
								</button>						
							</div>
						</form> 
					</div>
				</div>
			</div>
	    </c:otherwise>
	</c:choose>

</body>
</html>