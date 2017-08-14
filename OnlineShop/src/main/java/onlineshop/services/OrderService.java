package onlineshop.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import onlineshop.data.DataClass;
import onlineshop.entities.Order;
import onlineshop.entities.Product;

/**
 *
 * @author gihal
 */
public class OrderService {

    private Map<Long, Order> ordersMap = DataClass.getOrders();
    private ProductService productService = new ProductService();

    /**
     * Get all orders
     *
     * @return Returns the list of orders
     */
    public List<Order> getAllOrders() {
        return new ArrayList<Order>(ordersMap.values());
    }

    /**
     * Get the order by id
     *
     * @param id The id of the order
     * @return Return an Order
     */
    public Order getOrder(long id) {
        return ordersMap.get(id);
    }

    /**
     * Get the matching order that has the given product id.
     *
     * @param productId The product id in the order
     * @return Returns the Order if found. Otherwise returns null.
     */
    public Order getMatchingOrder(long productId) {
        for (Order existingOrder : getAllOrders()) {
            if (existingOrder.getPtrProduct() == productId) {
                return existingOrder;
            }
        }
        return null;
    }

    /**
     * Update the available quantity of the products when adding and removing
     * orders.
     *
     * @param order An Order which is going to be added or removed.
     * @param addOrder True if the order is going to be added. Otherwise false
     */
    private void updateAvailableProductQuantity(Order order, boolean addOrder) {
        Product product = productService.getProduct(order.getPtrProduct());
        if (addOrder) {
            product.setAvailableItems(product.getAvailableItems() - order.getQuantity());
        } else {
            product.setAvailableItems(product.getAvailableItems() + order.getQuantity());
        }
        productService.updateProduct(product);
    }

    /**
     * Add an order
     *
     * @param order The order going to be added
     */
    public void addOrder(Order order) {
        updateAvailableProductQuantity(order, true);
        Order matchingOrder = getMatchingOrder(order.getPtrProduct());
        int size = ordersMap.size();
        if (matchingOrder == null) {// adding a new product
            order.setId(size + 1);
        } else { //update the quantity of an existing order
            matchingOrder.setQuantity(order.getQuantity() + matchingOrder.getQuantity());
            order = matchingOrder;
        }
        ordersMap.put(order.getId(), order);
    }

    /**
     * Update the order in the order list
     *
     * @param order The order which is going to be updated
     */
    public void updateOrder(Order order) {
        Order existingOrder = ordersMap.get(order.getId());
        if(existingOrder==null){
            throw new IllegalArgumentException("Can't find an order. The  order might be removed");
        }
        Product product = productService.getProduct(order.getPtrProduct());
        int updateQuantity = order.getQuantity() - existingOrder.getQuantity();
        product.setAvailableItems(product.getAvailableItems() - updateQuantity);
        ordersMap.put(order.getId(), order);
    }

    /**
     * Removing order that match with the given id.
     *
     * @param orderId The id of the order which is going to be removed
     */
    public void removeOrder(long orderId) {
        Order order = getOrder(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Can't find an order with id " + orderId);
        }
        ordersMap.remove(orderId, order);
        updateAvailableProductQuantity(order, false);
    }
}
