<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="../js/admin-home-page.js"></script>

<body>
    <div id="wrapper">
        <jsp:include page="sidebar.jsp"></jsp:include>    

        <!-- Page Content -->
        <div id="page-content-wrapper">
                <form action="/logout">
                    <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle"><i class="fa fa-bars"></i></a>
                    <span class="dealer-notifications">Dealer Requests</span>   
                    <button class="btn btn-primary logout">Logout</button>        
                </form>
        </div>
        <!-- /#page-content-wrapper -->
		
        <div class="container-fluid">
            <c:choose>
                <c:when test="${not empty requestList}">
                    <c:forEach var="request" items="${requestList}">
                        <div class="row request-row" style="background-color:lightgrey;" id="record">
                            <div class="col-sm-2">
                                 <p>Request Id <span class="badge badge-primary" id="rid">${request.getRequestId()}</span></p>
                            </div>
                            <div class="col-sm-6">
                                <h2>${request.getName()}</h2> 
                                <ul class="list-unstyled">
                                 <li> <i class="fa fa-phone"></i> ${request.getContactDetails().getContactNumber()}</li>
                                  <li> <i class="fa fa-envelope"></i> ${request.getContactDetails().getMailId()}</li>
                                  <li> <i class="fa fa-address-card"></i> ${request.getContactDetails().getAddress()}</li>
                                </ul>
                            </div>
                            <div class="col-sm-4">
                                <ul class="list-inline">
                                  <li class="list-inline-item">
                                    <button class="btn btn-success  btn-lg accept">accept</button>
                                  </li>
                                  <li class="list-inline-item">
                                    <button class="btn btn-danger btn-lg reject">reject</button>
                                  </li>
                                </ul>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-info">
                        No pending requests
                    </div>
                </c:otherwise>
            </c:choose>
         </div>
    </div>
    <!-- /#wrapper -->

   
</body>

</html>
