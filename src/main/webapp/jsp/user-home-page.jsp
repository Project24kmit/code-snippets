<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<style type="text/css">
	.productbox {
    background-color:#ffffff;
	padding:20px;
	margin-bottom:15px;
	

	-webkit-box-shadow: 0 8px 6px -6px  #999;
	   -moz-box-shadow: 0 8px 6px -6px  #999;
	        box-shadow: 0 8px 6px -6px #999;
}

.producttitle {
    font-weight:bold;
	padding:5px 0 5px 0;
}

.productprice {
	border-top:1px solid #dadada;
	padding-top:5px;
}

.pricetext {
	font-weight:bold;
	font-size:1.4em;
}
</style>

<script type="text/javascript">
  $(document).ready(function(e) {   
      $('.addToCart').click(function(){
        $(this).text("Added to cart");
        $(this).attr('class','btn btn-info btn-lg');
        // make an ajax call and send the required parameters
      });
  });
</script>

<nav class="navbar navbar-default">
      <ul class="nav navbar-nav">
      	<li>
	    	<a class="navbar-brand" href="#">
	    		<img src="../images/cicon.png" width="30" height="30" > 
	    	</a>
	    </li>
      </ul>
      <form class="navbar-form" style="margin-top: 1%;">
        <div style="margin-left: 15%;" class="form-group">
          <input type="text" style="width: 600px;" class="form-control" placeholder="Search by category name">
        </div>
        <button type="submit" class="btn btn-primary"><i class="fa fa-search" aria-hidden="true"></i></button>

        <span style="margin-left: 35%;" class="dropdown">
          <a class="btn btn-primary btn-md" href="cart.html">
                    <i class="fa fa-shopping-cart"></i> Cart
                </a>&ensp;
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">USERNAME <span class="caret"></span></a>
          <ul class="dropdown-menu">
            <li><a href="#">Track order</a></li>
            <li><a href="#">Edit profile</a></li>
            <li><a href="#">Logout</a></li>
          </ul>
        </span>
      </form>
</nav>
<div class="container">
<div class="col-lg-3 col-md-3 col-sm-4 column productbox">
    <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg" class="img-responsive" >
    <div class="producttitle">Product 2</div>
    <div class="productprice"><div class="pull-right">
      <a href="#" class="btn btn-danger btn-lg addToCart" role="button">Add to Cart</a>
      <a href="payment.html" class="btn btn-primary btn-lg" role="button">BUY</a>
    </div>
    <div class="pricetext">£8.95</div></div>
</div>

<div class="col-lg-3 col-md-3 col-sm-4 column productbox">
    <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg" class="img-responsive" >
    <div class="producttitle">Product 2</div>
    <div class="productprice"><div class="pull-right">
      <a href="#" class="btn btn-danger btn-lg addToCart" role="button">Add to Cart</a>
      <a href="#" class="btn btn-primary btn-lg" role="button">BUY</a>
    </div>
    <div class="pricetext">£8.95</div></div>
</div>

<div class="col-lg-3 col-md-3 col-sm-4 column productbox">
    <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg" class="img-responsive" >
    <div class="producttitle">Product 2</div>
    <div class="productprice"><div class="pull-right">
      <a href="#" class="btn btn-danger btn-lg addToCart" role="button">Add to Cart</a>
      <a href="#" class="btn btn-primary btn-lg" role="button">BUY</a>
    </div>
    <div class="pricetext">£8.95</div></div>
</div>

<div class="col-lg-3 col-md-3 col-sm-4 column productbox">
    <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg" class="img-responsive" >
    <div class="producttitle">Product 2</div>
    <div class="productprice"><div class="pull-right">
      <a href="#" class="btn btn-danger btn-lg addToCart" role="button">Add to Cart</a>
      <a href="#" class="btn btn-primary btn-lg" role="button">BUY</a>
    </div>
    <div class="pricetext">£8.95</div></div>
</div>

<div class="col-lg-3 col-md-3 col-sm-4 column productbox">
    <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg" class="img-responsive" >
    <div class="producttitle">Product 2</div>
    <div class="productprice"><div class="pull-right">
      <a href="#" class="btn btn-danger btn-lg addToCart" role="button">Add to Cart</a>
      <a href="#" class="btn btn-primary btn-lg" role="button">BUY</a>
    </div>
    <div class="pricetext">£8.95</div></div>
</div>

<div class="col-lg-3 col-md-3 col-sm-4 column productbox">
    <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg" class="img-responsive" >
    <div class="producttitle">Product 2</div>
    <div class="productprice"><div class="pull-right">
      <a href="#" class="btn btn-danger btn-lg addToCart" role="button">Add to Cart</a>
      <a href="#" class="btn btn-primary btn-lg" role="button">BUY</a>
    </div>
    <div class="pricetext">£8.95</div></div>
</div>

<div class="col-lg-3 col-md-3 col-sm-4 column productbox">
    <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg" class="img-responsive" >
    <div class="producttitle">Product 2</div>
    <div class="productprice"><div class="pull-right">
      <a href="#" class="btn btn-danger btn-lg addToCart" role="button">Add to Cart</a>
      <a href="#" class="btn btn-primary btn-lg" role="button">BUY</a>
    </div>
    <div class="pricetext">£8.95</div></div>
</div>

<div class="col-lg-3 col-md-3 col-sm-4 column productbox">
    <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg" class="img-responsive" >
    <div class="producttitle">Product 2</div>
    <div class="productprice"><div class="pull-right">
      <a href="#" class="btn btn-danger btn-lg addToCart" role="button">Add to Cart</a>
      <a href="#" class="btn btn-primary btn-lg" role="button">BUY</a>
    </div>
    <div class="pricetext">£8.95</div></div>
</div>
<div class="col-lg-3 col-md-3 col-sm-4 column productbox">
    <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg" class="img-responsive" >
    <div class="producttitle">Product 2</div>
    <div class="productprice"><div class="pull-right">
      <a href="#" class="btn btn-danger btn-lg addToCart" role="button">Add to Cart</a>
      <a href="#" class="btn btn-primary btn-lg" role="button">BUY</a>
    </div>
    <div class="pricetext">£8.95</div></div>
</div>

<div class="col-lg-3 col-md-3 col-sm-4 column productbox">
    <img src="https://s.cdpn.io/3/dingo-dog-bones.jpg" class="img-responsive" >
    <div class="producttitle">Product 2</div>
    <div class="productprice"><div class="pull-right">
      <a href="#" class="btn btn-danger btn-lg addToCart" role="button">Add to Cart</a>
      <a href="#" class="btn btn-primary btn-lg" role="button">BUY</a>
    </div>
    <div class="pricetext">£8.95</div></div>
</div>
</div>
</html>
