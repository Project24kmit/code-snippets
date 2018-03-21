<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<jsp:include page="head.jsp"></jsp:include>
<body>
	<nav class="navbar sticky-top navbar-light bg-light">
		<a class="navbar-brand" href="#">
			<img src="../images/cicon.png" width="30" height="30" class="d-inline-block align-top" alt="">
			e-Cart
		</a>
		<ul class="nav justify-content-end">
			<li class="nav-item">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#userLoginModal">
					Buy products
				</button>
			</li>
			<li class="nav-item">
				&emsp;
			</li>
			<li class="nav-item">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#dealerLoginModal">
					Sell products
				</button>
			</li>
		</ul>
	</nav>   

	<div class="container">

		<!-- The User Login Modal -->
		
		<div class="modal fade" id="userLoginModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Login</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form method="post" id="userForm" action="/user">
							<input type="hidden" name="action" value="loginUser"/>
							<div class="row">
								<div class="form-group">
									<div class="col-md">
										<label for="uid">Enter ID</label>
										<input type="text" class="form-control" id="uid" name="uid" placeholder="Enter ID" required>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<div class="col-md">
										<label for="upassword">Enter Password</label>
										<input type="password" class="form-control" id="upassword" name="upassword" placeholder="Password" required>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md">
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</div>
							<a href="jsp/user-registration-page.jsp" class="btn btn-link">Not yet registered?</a>
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<!-- The Dealer Login Modal -->
		<div class="modal fade" id="dealerLoginModal">
			<div class="modal-dialog">
				<div class="modal-content">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">Login</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<form method="post" id="dealerForm" action="/dealer">
							<input type="hidden" name="action" value="loginDealer"/>
							<div class="row">
								<div class="form-group">
									<div class="col-md">
										<label for="did">Enter ID</label>
										<input type="text" class="form-control" id="did" name="did" placeholder="Enter ID" required>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<div class="col-md">
										<label for="dpassword">Enter Password</label>
										<input type="password" class="form-control" id="dpassword" name="dpassword" placeholder="Password" required>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md">
									<button type="submit" class="btn btn-primary">Submit</button>
								</div>
							</div>
							<a href="jsp/dealer-registration-page.jsp" class="btn btn-link">Not yet registered?</a>
						</form>
					</div>

				</div>
			</div>
		</div>

	</div>

	<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		<ol class="carousel-indicators">
			<li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
			<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img class="d-block w-100" src="../images/shop1.jpg" alt="First slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>Buy products</h5>
					<p>We offer wide variety of products</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="../images/shop2.jpg" alt="Second slide">
				<div class="carousel-caption d-none d-md-block">
					<h5>Sell products</h5>
					<p>You run a small scale business and worried about selling your products online? We are there to help you!</p>
				</div>
			</div>
			<div class="carousel-item">
				<img class="d-block w-100" src="../images/shop3.jpg" alt="Third slide">
			</div>
		</div>
		<a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span>
			<span class="sr-only">Previous</span>
		</a>
		<a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

</body>

</html>