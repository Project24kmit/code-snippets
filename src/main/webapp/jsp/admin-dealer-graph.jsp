<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="../js/sidebar.js"></script>

<body>
    <div id="wrapper">
        <jsp:include page="sidebar.jsp"></jsp:include>    
        <!-- Page Content -->
        <div id="page-content-wrapper">
            <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle"><i class="fa fa-bars"></i></a>
            <span class="dealer-notifications">Dealer graph</span>
            <button class="btn btn-primary logout">Logout</button>
        </div>
    
    <div class="container">
      <div class="col-lg-12 well">
        <div class="row">
        <form method="post" action="/admin">
            <div class="col-sm-12 form-group">
              <label>Enter Dealer ID</label>
              <input type="hidden" name="action" value="dealerName">
              <input autofocus type="text" required autofocus id="did" class="form-control" name="did" value="${dealer}">
              <br>
              <button type="submit" class="btn btn-primary submit">submit</button>
            </div>
        </form>    
        </div>
      </div>
    </div>
      
    <c:if test="${not empty salesList}">
            <div id="chart_div"></div>
   
            <script type="text/javascript">
        google.charts.load('current', {packages: ['corechart']});
  google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {
   var data = google.visualization.arrayToDataTable([
                  ['Date', 'No. of sales made'],
                  <c:forEach items="${salesList}" var="data">
                      [ '${data.getDate()}', ${data.getQuantity()} ],
                  </c:forEach>
            ]);

            var options = {
        title: 'Sales report for selected dealer',
        curveType:'function',
        legend:{position:'bottom'}
      };

      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));

      chart.draw(data, options);
  }
      </script>
    </c:if>

    <c:if test="${empty salesList && ISNULl !=dealer}">
       <div class="alert alert-danger">No data</div>
    </c:if>
      
</body>
</html>