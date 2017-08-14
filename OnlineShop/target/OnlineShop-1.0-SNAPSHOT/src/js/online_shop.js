
import '../css/online_shop.css';
var $ = require('jquery');

$(document).ready(function () {
    $.ajax({
        url: "/OnlineShop/GetProducts",
        type: "GET",
        success: function (products) {
            $.each(products, function (index, product) {
                $("#products").append("<div><label product-id='" + product.id + "'>" + product.name + ": </label><label>" + product.availableItems + " left</label></div>");
                $("#shop").append("<div><label>" + product.name + ": </label><input type='number' min='1' name='product-quantity' product-id='" + product.id + "' available-qty='" + product.availableItems + "' class='quantity'></div>");
            });
        },
        error: function (error, textStatus, jqXHR) {
            $("#error").toggleClass("hidden", false).html("Error:" + error.status + ". " + error.statusText);
        }
    });


    $("#shop").on("change keyup", "input.quantity", function () {
        var val = parseInt($(this).val());
        if (isNaN(val) || val <= 0) {
            $(this).val('');
            return false;
        }       
    });

    $("#btn-buy").click(function () {
        var orders = [];
        var error = null;

        $("input[name='product-quantity']").each(function () {
            var quantity = parseInt($(this).val());
            var product = parseInt($(this).attr("product-id"));
            var availableQty = parseInt($(this).attr("available-qty"));

            if (quantity <= 0) {
                error = "Invalid quantity";
                return false;
            }
            if (quantity > availableQty) {
                error = $("label[product-id='" + product + "']").html() + " deosn't has enough items";
                return false;
            }
            if (!isNaN(quantity)) {
                var order = {
                    ptrProduct: product,
                    quantity: quantity
                };
                orders.push(order);
            }

        });

        if (error === null && orders.length === 0) {
            error = "No items to add";
        }
        
        if (error === null) {            
            $.ajax({
                url: "/OnlineShop/AddProductsToOrder",
                type: "POST",
                data: {
                    products: JSON.stringify(orders)
                },
                success: function (data) {
                    window.location = '/OnlineShop/order_summary.html';                   
                },
                error: function (error, textStatus, jqXHR) {
                    $("#error").toggleClass("hidden", false).html("Error:" + error.status + ". " + error.statusText);
                }
            });
        } else {
            $("#error").toggleClass("hidden", false).html(error);
            return false;
        }


    });
    
    $("#btn-summary").click(function(){
        window.location = '/OnlineShop/order_summary.html';
    });

});