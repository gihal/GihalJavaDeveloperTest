/*
 * This class is used to generate orders in summary page * 
 * 
 */
package onlineshop.display;

import onlineshop.entities.Order;
import onlineshop.entities.Product;

/**
 *
 * @author gihal
 */
public class OrderDisplay {
    private Order order;
    private Product product;

    public OrderDisplay(Order order, Product product) {
        this.order = order;
        this.product = product;
    }    

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
}
