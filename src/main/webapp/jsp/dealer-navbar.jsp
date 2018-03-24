<nav class="navbar sticky-top navbar-light bg-light">
  <a class="navbar-brand" href="dealer.do">
    <img src="../images/cicon.png" width="30" height="30" class="d-inline-block align-top" alt="">
    e-Cart
  </a>
  <ul class="nav justify-content-end">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Add
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#addProductModal">Add product</a>
          <a class="dropdown-item" href="#" data-toggle="modal" data-target="#addCategoryModal">Add category</a>
        </div>
      </li>
	  <li class="nav-item">
	  &emsp;
	  </li>
	  <li class="nav-item">
	  <form action="dealer.do" method="post">
	  	<button type="submit" class="btn btn-primary" name="viewReports">
		  View reports
		</button>
	  </form>
	  </li>
	  &emsp;
	  <li class="nav-item">
	  <form action="dealer.do" method="post">
	  	<button type="submit" class="btn btn-primary" name="viewProfileSubmit">
		  View profile
		</button>
	  </form>
	  </li>
	  <li class="nav-item">
	  &emsp;
	  </li>
	  <li class="nav-item">
	  	<a href="/logout" class="btn btn-primary">Logout</a>
	  </li>
  </ul>
</nav>	