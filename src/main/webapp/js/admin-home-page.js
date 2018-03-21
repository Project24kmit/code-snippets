$(document).ready(function(e){

    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });

    $('.reject').click(function(){
        var request = $(this).parent().parent().parent().parent();
        var rid = $(".col-sm-2 p span",request).text()
        $.ajax({
           type:"POST",
           url: "/admin",
           data: { rid : rid , action:"reject" },
        });
        var row = $(this).parent().parent().parent().parent();
        row.html("<div class='alert alert-danger'>You rejected the request</div>")
        row.css('background-color','white');
        row.css('margin-left','38%');
    });

    $('.accept').click(function(){
        var request = $(this).parent().parent().parent().parent();
        var rid = $(".col-sm-2 p span",request).text()
        $.ajax({
           type:"POST",
           url: "/admin",
           data: { rid : rid , action:"accept"},
        });
        var row = $(this).parent().parent().parent().parent();
        row.html("<div class='alert alert-success'>Dealer registered successfully</div>");
        row.css('background-color','white');
        row.css('margin-left','33%');
    });
});