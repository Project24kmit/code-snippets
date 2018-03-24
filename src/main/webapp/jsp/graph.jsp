<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<jsp:include page="head.jsp"></jsp:include>


		
			<body>
			<c:if test="${not empty salesList}">
        		<div id="barchart_div"></div>
	

    
			<script type="text/javascript">
				google.charts.load('current', {packages: ['corechart', 'bar']});
	google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {
	 var data = google.visualization.arrayToDataTable([
                  ['Products', 'Units sold'],
                  <c:forEach items="${salesList}" var="data">
                      [ '${data.getProductName()}', ${data.getStockQuantity()} ],
                  </c:forEach>

            ]);

            var options = {
        title: 'Sales report for selected date',
        chartArea: {width: '80%' ,height: '80%'},
        hAxis: {
          title: 'Units sold',
          minValue: 0
        },
        vAxis: {
          title: 'Products'
        }
      };

      var chart = new google.visualization.BarChart(document.getElementById('barchart_div'));

      	chart.draw(data, options);
  }
			</script>
			</c:if>
			<c:if test="${empty salesList}">
			<div class="alert alert-danger">No data</div>
			</c:if>
      
</body>
</html>