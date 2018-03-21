<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="../js/sidebar.js"></script>

<body>
    <div id="wrapper">
        <jsp:include page="sidebar.jsp"></jsp:include>    

        <!-- Page Content -->
        <div id="page-content-wrapper">
                <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle"><i class="fa fa-bars"></i></a>
                <span class="dealer-notifications">Registered dealers</span>
        </div>

        <!-- /#page-content-wrapper -->
		<div class="container-fluid">
            <c:choose>
                <c:when test="${not empty dealerList}">
                    <c:forEach var="dealer" items="${dealerList}">
                        <div class="row request-row" id="record">
                            <div class="col-sm-2">
                                 <p>DealerId# <span class="badge badge-primary" id="rid">${dealer.getCredentials().getUsername()}</span></p>
                            </div>
                            <div class="col-sm-6">
                                <h2>${dealer.getName()}</h2> 
                                <ul class="list-unstyled">
                                 <li> <i class="fa fa-phone"></i> ${dealer.getContactDetails().getContactNumber()}</li>
                                  <li> <i class="fa fa-envelope"></i> ${dealer.getContactDetails().getMailId()}</li>
                                  <li> <i class="fa fa-address-card"></i> ${dealer.getContactDetails().getAddress()}</li>
                                </ul>
                            </div>
                            <div class="col-sm-4">
                                <h5><u>List of products sold</u></h5>
                                <ul class="multiselect">
                                    <c:forEach var="product" items="${dealer.getProducts()}">
                                        <li>${product.getProductName()}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>

                <c:otherwise>
                    <div class="alert alert-danger">
                        No dealers registered 
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>
    <!-- /#wrapper -->

    
</body>

</html>
