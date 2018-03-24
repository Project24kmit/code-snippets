<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<jsp:include page="head.jsp"></jsp:include>
<script type="text/javascript" src="../js/cart-page.js"></script>

<body>
    <br><h2 align="center">Shopping Cart</h2><br><br>

    <c:choose>
        <c:when test="${not empty orderList}">
            <div class="scroller">
                <table id="example" class="table table-striped table-bordered" style="width:100%">
                    <thead>
                        <tr>
                            <th>Product image</th>
                            <th>Prodcut title</th>                    
                            <th>Price</th>
                            <th>Quantity</th>                    
                            <th>Total</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orderList}">
                            <tr class="product">
                                <td><img src="${order.getProduct().getImageFilePath()}" class="img-responsive" width="100"></td>
                                <td>${order.getProduct().getProductName()}</td>
                                <td class="price">&#8377;${order.getProduct().getCost()}</td>
                                <td class="qty-td"><input class="qty" type="number" value="${order.getQuantity()}" name="${order.getTransactionId()}" /></td>
                                <td class="total">&#8377;${order.getTotal()}</td>
                                <td class="buttons">
                                    <button class="fa fa-trash btn btn-danger delete"></button>
                                    <button class="btn btn-info btn-sm update" disabled="disabled">save</button>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            
            <form method="post" action="/user">
                <div class="row payment" class="request-row">
                    <div class="col-sm-1">
                        
                    </div>
                    <div class="col-sm-4">
                        <a href="#" class="btn btn-primary btn-lg">continue shopping</a>
                    </div>
                    <div class="col-sm-2">
                        <h2>Total</h2>
                    </div>
                    <div class="col-sm-1 fin-qty-div"></div>
                    <div class="col-sm-2 fin-total-div"></div>
                   
                    <div class="col-sm-2">
                        <input type="hidden" id="amount" name="amount" value="">
                        <button type="submit" name="checkout" class="btn btn-success btn-lg">proceed to pay</button>
                    </div>
                </div>
            </form>
        </c:when>

        <c:otherwise>
            <div class="alert alert-danger">No items added to the cart</div>
            <div><a href="#" class="btn btn-primary btn-lg">continue shopping</a></div>
        </c:otherwise>
    </c:choose>
</body>
</html>