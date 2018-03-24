<html>

	<!-- Include head tag -->
	<jsp:include page="head.jsp"></jsp:include>

    <body>
		<nav class="navbar fixed-top navbar-light bg-light">
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
		
		<!-- The User Login Modal -->
		<div class="container">
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
		        <form action="user.do" method="post">
		        	<jsp:include page="login-form.jsp"></jsp:include>
		        </form>
		        <button type="button" class="btn btn-link">Not yet registered?</button>
		        </div>
		        
		      </div>
		    </div>
		  </div>
		</div>
		
		<!-- The Dealer Login Modal -->
		<div class="container">
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
		        <form action="dealer.do" method="post">
		        	<jsp:include page="login-form.jsp"></jsp:include>
		        </form>
		        <form action="dealer.do" method="post">
		        	<button class="btn btn-link" name="registerDealerPage">Not yet registered?</button>
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