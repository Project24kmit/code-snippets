<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/css/bootstrap-datetimepicker.min.css" />

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.6/moment.min.js"></script>   
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/4.17.37/js/bootstrap-datetimepicker.min.js"></script>

</head>
<body>
<form method="post" action="/graph">
	<input type="text" name="did"/>

  <div class="container">
    <div class="col-sm-6" style="height:130px;">
        <div class="form-group">
            <div class='input-group date' id='datetimepicker10'>
                <input type='text' name="date" class="form-control" />
                <span class="input-group-addon">
                    <span class="glyphicon glyphicon-calendar">
                    </span>
                </span>
            </div>
        </div>
    </div>
	<input type="submit" name="graph"/>
    <script type="text/javascript">
        $(function () {
            $('#datetimepicker10').datetimepicker({
                viewMode: 'years',
                format: 'MM-YYYY'
            });
        });
    </script>

</div>
</form>

</body>
</html>