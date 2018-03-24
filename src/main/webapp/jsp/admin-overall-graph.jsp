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
                <span class="dealer-notifications">Overall graph</span>
                <button class="btn btn-primary logout">Logout</button>
        </div>
		
			
			 <c:if test="${not empty salesList}">
        		<div id="chart_div"></div>
   
      			<script type="text/javascript">
      				google.charts.load('current', {packages: ['corechart', 'bar']});
      	google.charts.setOnLoadCallback(drawBasic);

      function drawBasic() {
      	 var data = google.visualization.arrayToDataTable([
                        ['Dealers', 'No. of sales made  '],
                        <c:forEach items="${salesList}" var="data">
                            [ '${data.getDealerId()}', ${data.getQuantity()} ],
                        </c:forEach>

                  ]);

                  var options = {
              title: 'Overall sales report',
              hAxis: {
                title: 'Overall sales',
                minValue: 0
              },
              vAxis: {
                title: 'Dealer Id'
              }
            };

            var chart = new google.visualization.BarChart(document.getElementById('chart_div'));

            	chart.draw(data, options);
        }
      			</script>
			</c:if>

			<c:if test="${empty salesList}">
			   <div class="alert alert-danger">No data</div>
			</c:if>
      
</body>
</html>