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
                <span class="dealer-notifications">Unregister a dealer</span>
        </div>
        <!-- /#page-content-wrapper -->

		<div class="container-fluid">
            <form method="post" action="/admin">
                <c:choose>
                    <c:when test="${empty dealer}">
                        <c:if test="${msg=='unregistered'}">
                            <div class="alert alert-success">
                            Unregistered the dealer. 
                            </div>
                        </c:if>

                        <c:if test="${msg=='null'}">
                            <div class="alert alert-info">
                                No dealer with the entered dealerID
                            </div>
                        </c:if>

                        <c:if test="${msg=='error'}">
                            <div class="alert alert-danger">
                                Could not unregister the dealer
                            </div>
                        </c:if>

                        <div class="form-group col-lg-3" style="margin-left:35%;">
                            <input  name="did" type="number" required placeholder="Enter dealer ID" class="form-control dealer-id">
                        </div>
                        <div><input type="submit" style="margin-left: 40%;" name="action" class="btn btn-info" value="getDealer"></div>
                    </c:when>

                    <c:otherwise>
                        <div class="row remove-dealer request-row">
                            <div class="col-sm-2">
                                 DealerId <input type="text" name="did" class="readonly" readonly value="${dealer.getCredentials().getUsername()}">
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
                        <input type="submit" style="margin-left: 45%;" name="action" class="btn btn-danger remove-dealer" value="unregisterDealer">
                    </c:otherwise>
                </c:choose>
        </div>
    <!-- /#wrapper -->
    </div>
</body>

</html>
