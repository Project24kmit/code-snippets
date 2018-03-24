<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<jsp:include page="head.jsp"></jsp:include>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharttable.org/master/jquery.highchartTable-min.js"></script>
<script>
    $(document).ready(function() {
      $('.highchart').highchartTable();
    });
</script>
<body>
<table class="highchart" data-graph-container-before="1" data-graph-type="column" style="display:none">
    <caption>Prodcut wise sale</caption>
    <thead>
        <tr>                                  
            <th>Product Name</th>
            <th>Units sold</th>
        </tr>
     </thead>
     <tbody>
        <tr>
            <td>Mobile</td>
            <td>100</td>
        </tr>
        <tr>
            <td>Camera</td>
            <td>120</td>
        </tr>
        <tr>
            <td>Laptops</td>
            <td>130</td>
        </tr>
<tr>
            <td>prod6</td>
            <td>290</td>
        </tr>
<tr>
            <td>prod5</td>
            <td>30</td>
        </tr>
<tr>
            <td>prod4</td>
            <td>500</td>
        </tr>
<tr>
            <td>prod3</td>
            <td>10</td>
        </tr>
<tr>
            <td>prod2</td>
            <td>250</td>
        </tr>
<tr>
            <td>prod1</td>
            <td>200</td>
        </tr>

    </tbody>
</table
</body>
</html>