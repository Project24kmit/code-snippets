<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

	<!-- Include head tag -->
	<jsp:include page="head.jsp"></jsp:include>
   	

    <!-- JS for data tables -->
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>
    <script src="../js/datatable-init.js"></script>
   	
    <body>
		
		<!-- Include dealer page navbar -->
		<jsp:include page="dealer-navbar.jsp"></jsp:include>
		<br>

		<div class="container col-lg-12">
		<nav>
		  <div class="nav nav-tabs" id="nav-tab" role="tablist">
		    <a class="nav-item nav-link active" id="nav-productStocks-tab" data-toggle="tab" href="#nav-productStocks" role="tab" aria-controls="nav-productStocks" aria-selected="true">Products Stocks</a>
		    <a class="nav-item nav-link" id="nav-graphs-tab" data-toggle="tab" href="#nav-graphs" role="tab" aria-controls="nav-graphs" aria-selected="false">Graphs</a>
		  </div>
		</nav>

		<div class="tab-content" id="nav-tabContent">
		  <br>
		  <div class="tab-pane fade show active" id="nav-productStocks" role="tabpanel" aria-labelledby="nav-productStock-tab">
		  
		  <!-- Data tables -->		  
			<div id="productsTable">
			<table id="example" class="table table-striped table-bordered">
			        <thead>
			            <tr>
			                <th>Product Name</th>
			                <th>Category</th>
			                <th>Description</th>
			                <th>Cost</th>
			                <th>Available Stock</th>
			                <th>Image</th>
			            </tr>
			        </thead>
			        
			        <tbody>
						<c:forEach items="${products}" var="product">
							<tr>
								<td>${product.productName}</td>
								<c:forEach items="${categories}" var="category">
									<c:if test="${product.categoryId==category.categoryId}">
										<td>${category.categoryName}</td>
									</c:if>
								</c:forEach>
								<td>${product.productDescription}</td>
								<td>${product.cost}</td>
								<td>${product.stockQuantity}</td>
								<td>
							  		<img class="card-img-top" src="${product.imageFilePath}" height="80" width="80" alt="product image">
							  	</td>
							</tr>
						</c:forEach>
			        </tbody>
			</table>
			</div>
		  </div>
		  
		  
		  <div class="tab-pane fade show active" id="nav-graphs" role="tabpanel" aria-labelledby="nav-graphs-tab">
		  
		  <!-- Graphs tags will come here -->
		  
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