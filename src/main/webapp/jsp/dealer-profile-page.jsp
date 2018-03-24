<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<!-- Include head tag -->
<jsp:include page="head.jsp"></jsp:include>

<body>

	<!-- Include dealer page navbar -->
	<jsp:include page="dealer-navbar.jsp"></jsp:include>
	<br>

	<div class="container alert alert-secondary">
		<div class="row">
			<div class="col-md-7">
				<div class="row">
					<div class="col-sm-6 col-md-8">
						<h4>${dealerDetails.company}</h4>
						<h5>
							<span class="badge badge-secondary">Dealer name </span> <br />
							${dealerDetails.name}
						</h5>
						<br />
						<h5>
							<span class="badge badge-secondary">Address </span> <br />
							${dealerDetails.contactDetails.address}
						</h5>
						<br />
						<h5>
							<span class="badge badge-secondary">Contact number </span> <br />
							${dealerDetails.contactDetails.contactNumber}
						</h5>
						<br />
						<h5>
							<span class="badge badge-secondary">e-Mail </span> <br />
							${dealerDetails.contactDetails.mailId}
						</h5>
						<br />
						<button class="btn btn-primary" role="button" data-toggle="modal"
							data-target="#${userId}Edit">Edit profile</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="${userId}Edit">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">Edit profile</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<!-- Modal body -->
				<div class="modal-body">
					<form method="post" action="/dealer.do">
						<div class="col-sm-12">
							<div class="form-group">
								<label>Name</label> <input autofocus type="text"
									name="firstName" class="form-control"
									value="${dealerDetails.name}" required> <input
									type="hidden" name="lastName" value="">
							</div>
							<div class="form-group">
								<label>Address</label>
								<textarea rows="2" name="address" class="form-control" required>${dealerDetails.contactDetails.address}</textarea>
							</div>
							<div class="form-group">
								<label>Phone Number</label>
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text" id="basic-addon1">+91</span>
									</div>
									<input type="number" class="form-control" name="mobile"
										aria-label="phonenumber" aria-describedby="basic-addon1"
										value="${dealerDetails.contactDetails.contactNumber}" required>
								</div>
							</div>
							<div class="form-group">
								<label>Email Address</label> <input type="email"
									value="${dealerDetails.contactDetails.mailId}" name="email"
									class="form-control" required>
							</div>
							<button type="submit" name="updateDealerDetails"
								class="btn btn-primary">Save changes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<!-- The add catgeory Modal -->
		<div class="container">
		  <div class="modal fade" id="addCategoryModal">
		    <div class="modal-dialog">
		      <div class="modal-content">
		      
		        <!-- Modal Header -->
		        <div class="modal-header">
		          <h4 class="modal-title">Add new category</h4>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		        
		        <!-- Modal body -->
		        <div class="modal-body">
		        <form action="dealer.do" method="post">
						<div class="row">
					 		<div class="form-group">
					 			<div class="col-md">
							   		<label for="categoryName">Category name</label>
							   		<input autofocus type="text" class="form-control" id="categoryName" name="categoryName" required>
					 			</div>
					 		</div>
						</div>
					  	<div class="row">
					 		<div class="col-md">
					 		<button type="submit" class="btn btn-primary" name="addCategorySubmit">Submit</button>
					 		</div>
						</div>
		        </form>
		        </div>
		        
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- The add product Modal -->
		<div class="container">
		  <div class="modal fade" id="addProductModal">
		    <div class="modal-dialog">
		      <div class="modal-content">
		      
		        <!-- Modal Header -->
		        <div class="modal-header">
		          <h4 class="modal-title">Add new product</h4>
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		        </div>
		        
		        <!-- Modal body -->
		        <div class="modal-body">
		        <form action="dealer.do" method="post" enctype="multipart/form-data">
					<div class="form-group">  
					  <div class="col-md">
					  	<label for="productName">Product Name</label>
						<input autofocus id="productName" name="productName" class="form-control input-md" required type="text">				    
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
					  	<label for="productDescription">Product Description</label>  
					    <input id="productDescription" name="productDescription" class="form-control input-md" required type="text">
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
					  	<label for="productCost">Product Cost</label>  
					    <input id="productCost" name="productCost" class="form-control input-md" required type="number" step="any">
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
					  	<label for="productCategory">Product Category</label>
						<input id="productCategory" name="productCategory" class="form-control input-md" required type="text">
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
					  	<label for="productQuantity">Available Quantity</label>  
					    <input id="productQuantity" name="productQuantity" class="form-control input-md" required type="text">
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
			            <div class="input-group image-preview">
			                <input type="text" class="form-control image-preview-filename" disabled="disabled">
			                <span class="input-group-btn">
			                    <!-- image-preview-clear button -->
			                    <button type="button" class="btn btn-default image-preview-clear" style="display:none;">
			                        <span class="glyphicon glyphicon-remove"></span> Clear
			                    </button>
			                    <!-- image-preview-input -->
			                    <div class="btn btn-default image-preview-input">
			                        <span class="glyphicon glyphicon-folder-open"></span>
			                        <span class="image-preview-input-title">Browse</span>
			                        <input type="file" accept="image/png, image/jpeg, image/gif" name="productImage"/>
			                    </div>
			                </span>
			            </div>
					  </div>
					</div>
					<div class="form-group">
					  <div class="col-md">
				 		<button type="submit" class="btn btn-primary" name="addProductSubmit">Submit</button>
					  </div>
					</div>
		        </form>
		        </div>
		        
		      </div>
		    </div>
		  </div>
		</div>

</body>
</html>