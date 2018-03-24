<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<jsp:include page="head.jsp"></jsp:include>


		
			<script type="text/javascript">
				google.charts.load('current', {packages: ['corechart']});
	google.charts.setOnLoadCallback(drawBasic);

function drawBasic() {
	 var data = google.visualization.arrayToDataTable([
                  ['Date', 'Units sold'],
                  <c:forEach items="${salesList}" var="data">
                      [ '${data.getProductName()}', ${data.getStockQuantity()} ],
                  </c:forEach>
            ]);

            var options = {
        title: 'Sales report',
      };

      var chart = new google.visualization.PieChart(document.getElementById('barchart_div'));

      chart.draw(data, options);
  }
			</script>
			<body>
        		<div id="barchart_div" style="width: 900px;height: 500px;"></div>
	

    
      
</body>
</html>