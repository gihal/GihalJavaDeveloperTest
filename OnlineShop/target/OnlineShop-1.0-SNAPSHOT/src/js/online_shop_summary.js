var $ = require('jquery');

$(document).ready(function () {
    $.ajax({
        url: "/OnlineShop/GetOrders",
        type: "GET",
        success: function (ordersDisplay) {
            $.each(ordersDisplay, function (index, orderDisplay) {
                var product = orderDisplay.product;
                var order = orderDisplay.order;
                $("#summary").append("<div>\n\
                                   <label product-id='" + product.id + "'>" + product.name + ": </label>\n\
                                   <input type='number' min='1' name='product-quantity' value='" + order.quantity + "' order-id='" + order.id + "' product-id='" + product.id + "' available-qty='" + product.availableItems + "' class='quantity'>\n\
                                   <button class='btn btn-red btn-sm btn-remove-order' order-id='" + order.id + "'>Remove</button>\n\
                                   </div>");
            });
        },
        error: function (error, textStatus, jqXHR) {
            $("#error").toggleClass("hidden", false).html("Error:" + error.status + ". " + error.statusText);
        }
    });

    $("#btn-back").click(function () {
        window.location = '/OnlineShop/';
    });

    $("#btn-update").click(function () {
        var orders = [];
        var error = null;
        $("input[name='product-quantity']").each(function () {
            var quantity = parseInt($(this).val());
            var order = parseInt($(this).attr("order-id"));
            var product = parseInt($(this).attr("product-id"));
            var availableQty = parseInt($(this).attr("available-qty")) + parseInt($(this).attr("value"));

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
                    id: order,
                    ptrProduct:product,
                    quantity: quantity
                };
                orders.push(order);
            }

        });

        if (error === null) {
            $.ajax({
                url: "/OnlineShop/UpdateOrder",
                type: "POST",
                data: {
                    orders: JSON.stringify(orders)
                },
                success: function (data) {
                    location.reload();
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

    $("#summary").on("click", "button.btn-remove-order", function () {
        var orderId = $(this).attr("order-id");
        $.post("/OnlineShop/RemoveOrder?order-id=" + orderId)
                .done(function () {
                    location.reload();
                })
                .fail(function (error) {
                    $("#error").toggleClass("hidden", false).html("Error:" + error.status + ". " + error.statusText);
                });
    });
});