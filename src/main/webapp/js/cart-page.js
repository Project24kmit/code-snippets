$(document).ready(function(e) {   
            $('.qty').change(function(){
                var button = $(this).parent().parent().children().children();
                $(button).prop('disabled', false);
                updateCost(this);
            });

            $('.delete').click(function(){
                deleteItem(this);
            });            
            
            $('.update').click(function(){
                updateItem(this);
            });

            var row = $('.product');
            var rupee = $(row.children('.price')).text().slice(0,1)
            recalculateCart(rupee); 

        });

        function deleteItem(input){
             var productRow = $(input).parent().parent();
             var tid = $($(productRow).children('.qty-td')).children('.qty').attr("name")
             $.ajax({
               type:"POST",
               url: "/user",
               data: { tid : tid , action:"deleteItem"},
             });
             productRow.slideUp(200, function() {
             productRow.remove();
             var rupee = $(productRow.children('.price')).text().slice(0,1)
             recalculateCart(rupee); 
           });
        }

        function updateItem(input){
             var productRow = $(input).parent().parent();
             var row = $($(productRow).children('.qty-td')).children('.qty')
             var qty = row.val();
             var tid = row.attr('name');
             $.ajax({
               type:"POST",
               url: "/user",
               data: { tid : tid , qty:qty , action:"updateItem"},
             });
             
             var button = productRow.children('.buttons').children('.update');
             $(button).prop('disabled', true);
        }

        function updateCost(input) {
            var row = $(input).parent().parent();
            var price = parseFloat($(row.children('.price')).text().slice(1));
            var rupee = $(row.children('.price')).text().slice(0,1)
            var quantity = $(input).val();
            var linePrice = price * quantity;
            $(row.children('.total')).text(rupee+linePrice.toFixed(2));
            recalculateCart(rupee);
        }

        function recalculateCart(rupee) {
            var fin_qty = 0;
            var fin_total = 0;

            $('.product').each(function () {
                fin_total += parseFloat($(this).children('.total').text().slice(1));
            });

            $('.product').each(function () {
                fin_qty += parseInt($($(this).children('.qty-td')).children('.qty').val());
            });

            var row = $('.payment');
            row.children('.fin-qty-div').text(fin_qty);
            row.children('.fin-total-div').text(rupee+fin_total.toFixed(2));
            document.getElementById('amount').value=fin_total;

        }